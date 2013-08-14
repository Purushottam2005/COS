package com.cloud.cos.dao.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.dao.ResourceDao;

@Transactional
@Repository
public class ResourceDaoImpl extends HibernateDaoSupport implements ResourceDao{

	private Logger log = Logger.getLogger(ResourceDaoImpl.class);
	
	@Autowired
	@Resource(name = "sessionFactory")
	public void setSessionFactoryCos(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public ResourceLocation save(ResourceLocation resource) {
		Integer pk=(Integer)this.getHibernateTemplate().save(resource);
		return this.getHibernateTemplate().get(ResourceLocation.class, pk);
	}

}
