package com.cloud.cos.mule.routers;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.alibaba.fastjson.JSONObject;
import com.cloud.cos.bean.Tenant;
import com.cloud.cos.service.TenantService;

public class TenantMsgProcessor extends AbstractAggregator implements
		MessageProcessor {

	private Logger log = Logger.getLogger(TenantMsgProcessor.class);
	@Autowired
	private TenantService tenantService;
	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		addTenant();
		log.info(">>>into the processor");
		List<Tenant> tenantlist=tenantService.getAll();
		
		log.info(">>>into the processor2");
		MuleMessage msg= event.getMessage();
		log.info(">>>payload:"+msg.getPayload());
		String json=JSONObject.toJSONString(tenantlist);
		msg.setPayload(json);
		event.setMessage(msg);
		log.info(">>>payload2:"+msg.getPayload());
		return event;
	}

	@Override
	protected EventCorrelatorCallback getCorrelatorCallback(
			MuleContext muleContext) {
		EventCorrelatorCallback ecc=new CollectionCorrelatorCallback(muleContext, false, null);
		return ecc;
	}
	
	public void addTenant(){
		log.info("start to add tenant...");
		Tenant tenant = new Tenant();
		Date dnow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		tenant.setCreateDate(sdf.format(dnow));
		tenant.setCreatorId(123);
		tenant.setCreatorName("tester");
		tenant.setDisabled(0);
		tenant.setDomainName("lif@portal.com");
		tenant.setId(123);
		tenant.setName("FOcek");
		tenant.setRemark("255.255.255.0");
		tenantService.addTenant(tenant);
		log.info("complete add tenant...");
	}

}
