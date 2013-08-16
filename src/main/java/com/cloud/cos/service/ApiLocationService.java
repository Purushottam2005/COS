package com.cloud.cos.service;

import java.util.List;

import com.cloud.cos.bean.ApiLocation;

public interface ApiLocationService {
	public boolean add(ApiLocation apiLocation);

	public List<ApiLocation> getAllList();
}
