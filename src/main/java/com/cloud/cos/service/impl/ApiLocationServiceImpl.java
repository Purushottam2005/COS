package com.cloud.cos.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.cos.bean.ApiLocation;
import com.cloud.cos.dao.ApiLocationDao;
import com.cloud.cos.service.ApiLocationService;

@Service
public class ApiLocationServiceImpl implements ApiLocationService {
	private Logger log = Logger.getLogger(ResourceLocationServiceImpl.class);
	@Autowired
	private ApiLocationDao apiLocationDao;
	@Override
	public boolean add(ApiLocation apiLocation) {
		// TODO Auto-generated method stub
		return apiLocationDao.save(apiLocation);
	}
	@Override
	public List<ApiLocation> getAllList() {
		// TODO Auto-generated method stub
		return apiLocationDao.getAllList();
	}

}
