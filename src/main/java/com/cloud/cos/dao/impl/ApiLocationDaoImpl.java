package com.cloud.cos.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.cos.bean.ApiLocation;
import com.cloud.cos.dao.ApiLocationDao;

@Transactional
@Repository
public class ApiLocationDaoImpl extends HibernateDaoSupport implements
		ApiLocationDao {

	private Logger log = Logger.getLogger(ApiLocationDaoImpl.class);

	@Autowired
	@Resource(name = "sessionFactory")
	public void setCosSessionFactory(SessionFactory sessionFactory) {
		log.info("setCosSessionFactory");
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public List<ApiLocation> getAllList() {
		log.info("get ApiLocation all list");
		return this.getHibernateTemplate().find("from ApiLocation");
	}

	@Override
	public boolean save(ApiLocation apiLocation) {
		log.info("insert ApiLocation");
		this.getHibernateTemplate().save(apiLocation);
		return true;
	}

}
