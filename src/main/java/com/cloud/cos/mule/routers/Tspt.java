package com.cloud.cos.mule.routers;

import org.apache.log4j.Logger;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;
import org.mule.routing.AbstractAggregator;
import org.mule.routing.correlation.CollectionCorrelatorCallback;
import org.mule.routing.correlation.EventCorrelatorCallback;

public class Tspt extends AbstractAggregator implements MessageProcessor {

	private Logger log = Logger.getLogger(Tspt.class);
	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {

		EventCorrelatorCallback ecc = new CollectionCorrelatorCallback(
				muleContext, false, null);
		return ecc;
	}

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		event.setSessionVariable("sendtoSession", "KNSDJFKhsdklnNSDNFJKSHDFSDFKHSDKF");
		return event;
	}
}
