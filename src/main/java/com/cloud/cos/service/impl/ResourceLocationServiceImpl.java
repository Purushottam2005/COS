package com.cloud.cos.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.dao.ResourceLocationDao;
import com.cloud.cos.service.ResourceLocationService;
@Service
public class ResourceLocationServiceImpl implements ResourceLocationService {
	
	private Logger log = Logger.getLogger(ResourceLocationServiceImpl.class);
	@Autowired
	private ResourceLocationDao resourceDao;

	@Override
	public boolean addResource(ResourceLocation resource) {
		log.info("save service");
		return resourceDao.save(resource);
	}

	@Override
	public List<ResourceLocation> getAllList() {
		log.info("getAllList service");
		return resourceDao.getAllList();
	}

	@Override
	public ResourceLocation getResourceLocation(int id) {
		log.info("get service");
		return resourceDao.getResourceLocation(id);
	}

}
