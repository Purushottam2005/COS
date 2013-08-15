package com.cloud.cos.dao;

import java.util.List;

import com.cloud.cos.bean.ApiLocation;


public interface ApiLocationDao{
	public boolean save(ApiLocation apiLocation);
	
	public List<ApiLocation> getAllList();
}
