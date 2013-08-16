package com.cloud.cos.service;

import java.util.List;

import com.cloud.cos.bean.ResourceLocation;

public interface ResourceLocationService {
	
	public boolean addResource(ResourceLocation resource);
	
	public List<ResourceLocation> getAllList();

}
