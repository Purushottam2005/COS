package com.cloud.cos.mule.routers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.client.MuleClient;
import org.mule.routing.AbstractAggregator;
import org.mule.routing.correlation.CollectionCorrelatorCallback;
import org.mule.routing.correlation.EventCorrelatorCallback;

import com.alibaba.fastjson.JSON;
import com.cloud.cos.bean.ApiLocation;

public class ChoiceFlowMsgProcessor extends AbstractAggregator implements
		MessageProcessor {

	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {
		EventCorrelatorCallback ecc = new CollectionCorrelatorCallback(
				muleContext, false, null);
		return ecc;
	}
	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		MuleMessage mmsg = event.getMessage();
	
		event.setFlowVariable("mesg", "hahahahahha");
		return event;
	}

}
