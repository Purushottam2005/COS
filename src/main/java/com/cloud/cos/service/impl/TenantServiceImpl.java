package com.cloud.cos.service.impl;

import java.util.List;

import javax.ws.rs.Path;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.cos.bean.Tenant;
import com.cloud.cos.dao.TenantDao;
import com.cloud.cos.service.TenantService;
@Service
public class TenantServiceImpl implements TenantService {

	private Logger log = Logger.getLogger(TenantServiceImpl.class);
	@Autowired
	private TenantDao tenantDao;
	@Override
	public List<Tenant> getAll() {
		log.info(">>>into the service");
		return tenantDao.getAllTenant();
	}
	@Override
	public Tenant addTenant(Tenant tenant) {
		return tenantDao.save(tenant);
	}
	@Override
	@Path("/sayHello")
	public String testTenant() {
		// TODO Auto-generated method stub
		return "sayHello";
	}

}
