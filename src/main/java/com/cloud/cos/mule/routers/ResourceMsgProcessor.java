package com.cloud.cos.mule.routers;

import java.util.List;

import org.apache.log4j.Logger;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.routing.AbstractAggregator;
import org.mule.routing.correlation.CollectionCorrelatorCallback;
import org.mule.routing.correlation.EventCorrelatorCallback;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.service.ResourceLocationService;

public class ResourceMsgProcessor extends AbstractAggregator implements
		MessageProcessor {

	private Logger log = Logger.getLogger(ResourceMsgProcessor.class);

	@Autowired
	private ResourceLocationService resourceService;

	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {
		EventCorrelatorCallback ecc = new CollectionCorrelatorCallback(
				muleContext, false, null);
		return ecc;
	}

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		log.info("start to insert resources");
		addResource();
		log.info("start to query resources");
		MuleMessage mgs = event.getMessage();
		List<ResourceLocation> list = resourceService.getAllList();
		String listInfo = JSON.toJSONString(list);
		mgs.setPayload(listInfo);
		event.setMessage(mgs);
		log.info("end processor...");
		return event;
	}

	public void addResource() {
		log.info("add resource");
		ResourceLocation resource = new ResourceLocation();
		resource.setHost("19216011");
		resource.setPort(80);
		resource.setName("myresource");
		resourceService.addResource(resource);
		log.info("complete add resource...");
	}
}
