package com.cloud.cos.mule.routers;

import org.mule.api.MuleContext;
import org.mule.api.processor.MessageProcessor;
import org.mule.routing.AbstractAggregator;
import org.mule.routing.correlation.CollectionCorrelatorCallback;
import org.mule.routing.correlation.EventCorrelatorCallback;

public class DefaultProcess extends AbstractAggregator implements
		MessageProcessor {

	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {
		EventCorrelatorCallback ecc = new CollectionCorrelatorCallback(
				muleContext, false, null);
		return ecc;
	}

}
