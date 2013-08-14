package com.cloud.cos.service;

import java.util.List;

import com.cloud.cos.bean.Tenant;

public interface TenantService {
	public List<Tenant> getAll();

	public Tenant addTenant(Tenant tenant);
	
	public String testTenant();
}
