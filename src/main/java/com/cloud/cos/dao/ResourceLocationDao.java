package com.cloud.cos.dao;

import java.util.List;

import com.cloud.cos.bean.ResourceLocation;

public interface ResourceLocationDao{
	public boolean save(ResourceLocation resourceLocation);
	
	public List<ResourceLocation> getAllList();
}
