package com.cloud.cos.dao;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.bean.Tenant;

public interface ResourceDao {

	public ResourceLocation save(ResourceLocation resource);
}
