package com.cloud.cos.mule.routers;

import java.util.List;

import org.apache.log4j.Logger;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;
import org.mule.routing.AbstractAggregator;
import org.mule.routing.correlation.CollectionCorrelatorCallback;
import org.mule.routing.correlation.EventCorrelatorCallback;
import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.cos.bean.ApiLocation;
import com.cloud.cos.dao.ApiLocationDao;
import com.cloud.cos.service.ResourceLocationService;

public class TestMsgProcessor extends AbstractAggregator implements
MessageProcessor {

	private Logger log = Logger.getLogger(ResourceMsgProcessor.class);
	
	@Autowired
	private ResourceLocationService resourceService;
	
	@Autowired
	private ApiLocationDao apiLocationDao;
	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {
		EventCorrelatorCallback ecc=new CollectionCorrelatorCallback(muleContext, false, null);
		return ecc;
	}
	
	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		List<ApiLocation> list = apiLocationDao.getAllList();
		
		return event;
	}
}
