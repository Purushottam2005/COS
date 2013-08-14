package com.cloud.cos.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.dao.ResourceDao;
import com.cloud.cos.service.ResourceService;
@Service
public class ResourceServiceImpl implements ResourceService {
	
	private Logger log = Logger.getLogger(ResourceServiceImpl.class);
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public boolean addResource(ResourceLocation resource) {
		return resourceDao.save(resource);
	}

}
