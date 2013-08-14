package com.cloud.cos.mule.routers;

import org.apache.log4j.Logger;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;
import org.mule.routing.AbstractAggregator;
import org.mule.routing.correlation.CollectionCorrelatorCallback;
import org.mule.routing.correlation.EventCorrelatorCallback;
import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.service.ResourceService;

public class ResourceMsgProcessor extends AbstractAggregator implements
MessageProcessor {

	private Logger log = Logger.getLogger(ResourceMsgProcessor.class);
	
	@Autowired
	private ResourceService resourceService;
	
	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {
		EventCorrelatorCallback ecc=new CollectionCorrelatorCallback(muleContext, false, null);
		return ecc;
	}
	
	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		addResource();
		
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
