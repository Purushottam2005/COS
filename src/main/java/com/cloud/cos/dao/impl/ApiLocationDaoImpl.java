package com.cloud.cos.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.cos.bean.ApiLocation;
import com.cloud.cos.dao.ApiLocationDao;
import com.cloud.cos.dao.BaseDao;
@Transactional
@Repository
public class ApiLocationDaoImpl extends BaseDao<ApiLocation,Integer> implements ApiLocationDao{

}
