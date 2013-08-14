package com.cloud.cos.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.dao.BaseDao;
import com.cloud.cos.dao.ResourceDao;

@Transactional
@Repository
public class ResourceDaoImpl  extends BaseDao<ResourceLocation,Integer> implements ResourceDao{

	private Logger log = Logger.getLogger(ResourceDaoImpl.class);
}
