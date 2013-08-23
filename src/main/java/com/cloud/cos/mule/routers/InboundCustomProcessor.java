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

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.service.ResourceLocationService;

public class InboundCustomProcessor extends AbstractAggregator implements MessageProcessor{
	
	private Logger log = Logger.getLogger(InboundCustomProcessor.class);

	@Autowired
	private ResourceLocationService resourceService;

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		ResourceLocation resourceLocation = resourceService.getResourceLocation(1);
		
		System.out.println("###################################");
		System.out.println("id:                        " + resourceLocation.getId());
		System.out.println("name:                      " + resourceLocation.getName());
		System.out.println("host:                      " + resourceLocation.getHost());
		System.out.println("port:                      " + resourceLocation.getPort());
		System.out.println("protocol:                  " + resourceLocation.getProtocol());
		System.out.println("###################################");
		
		List<Object> payloadList = new ArrayList<Object>();
		MuleMessage msg = event.getMessage();
		MuleClient client = new MuleClient(muleContext);
		Map<String, String> props = new HashMap<String, String>();
		props.put("http.method", "PUT");
		MuleMessage result = client.send("http://" + resourceLocation.getHost()
				+ ":" + resourceLocation.getPort() + resourceLocation.getName(),
				msg.getPayload(), props);
		 log.info("the one client message:" + result);
		payloadList.add(result.getPayload(String.class));
		return event;
	}

	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {
		EventCorrelatorCallback ecc = new CollectionCorrelatorCallback(
				muleContext, false, null);
		return ecc;
	}

}
