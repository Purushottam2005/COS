package com.cloud.cos.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.dao.ResourceLocationDao;

@Transactional
@Repository
public class ResourceLocationDaoImpl  extends HibernateDaoSupport implements ResourceLocationDao{

	private Logger log = Logger.getLogger(ResourceLocationDaoImpl.class);

	@Autowired
	@Resource(name = "sessionFactory")  
	public void setCosSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public boolean save(ResourceLocation resourceLocation) {
		this.getHibernateTemplate().save(resourceLocation);
		log.info("insert ResourceLocation");
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourceLocation> getAllList() {
		log.info("getAllList ResourceLocations");
		return getHibernateTemplate().find("from ResourceLocation");
	}
	@Override
	public ResourceLocation getResourceLocation(int id) {
		log.info("get ResourceLocation by id");
		return (ResourceLocation) getHibernateTemplate().find("from ResourceLocation where resourceId =" + id);
	}
	
	
}
