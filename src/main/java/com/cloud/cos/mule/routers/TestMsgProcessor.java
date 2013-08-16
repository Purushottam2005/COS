package com.cloud.cos.mule.routers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.client.MuleClient;
import org.mule.routing.AbstractAggregator;
import org.mule.routing.correlation.CollectionCorrelatorCallback;
import org.mule.routing.correlation.EventCorrelatorCallback;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cloud.cos.bean.ApiLocation;
import com.cloud.cos.service.ApiLocationService;
import com.cloud.cos.service.ResourceLocationService;

public class TestMsgProcessor extends AbstractAggregator implements
		MessageProcessor {

	private Logger log = Logger.getLogger(ResourceMsgProcessor.class);

	@Autowired
	private ResourceLocationService resourceService;

	@Autowired
	private ApiLocationService apiLocationService;

	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {

		EventCorrelatorCallback ecc = new CollectionCorrelatorCallback(
				muleContext, false, null);
		return ecc;
	}

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		List<ApiLocation> list = apiLocationService.getAllList();
		List<Object> payloadList= new ArrayList<Object>();
		for(int i=0;i<1000;i++)
		for(ApiLocation apiLocation:list){
			MuleClient client = new MuleClient(muleContext);
			Map<String, String> props = new HashMap<String, String>();
			props.put("http.method", "PUT");
			MuleMessage result = client.send("http://localhost:80/rest/test","",props);
			log.info("the one client message:"+result);
			payloadList.add(result.getPayload(String.class));
		}
		String payload = JSON.toJSONString(payloadList);
		log.info("the all message"+payload);
		MuleMessage msg = event.getMessage();
		msg.setPayload(payload);
		event.setMessage(msg);
		return event;
	}
}
