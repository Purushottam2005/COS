package com.cloud.cos.mule.routers;

import org.apache.log4j.Logger;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.service.ResourceLocationService;

public class InboundCustomProcessor implements MessageProcessor{
	
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
		return null;
	}

}
