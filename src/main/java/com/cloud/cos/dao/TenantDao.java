package com.cloud.cos.dao;

import java.util.List;

import com.cloud.cos.bean.Tenant;

public interface TenantDao {
	 
	public Tenant save(Tenant tenant);
	public List<Tenant> getAllTenant();

}
