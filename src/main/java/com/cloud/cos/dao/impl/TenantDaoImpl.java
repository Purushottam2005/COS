package com.cloud.cos.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.cos.bean.Tenant;
import com.cloud.cos.dao.TenantDao;
@Transactional
@Repository
public class TenantDaoImpl extends HibernateDaoSupport implements TenantDao{

	private Logger log = Logger.getLogger(TenantDaoImpl.class);
	@Autowired
	@Resource(name = "sessionFactory")  
	public void setSessionFactoryCos(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tenant> getAllTenant() {
		log.info(">>>into the dao");
		return (List<Tenant> )this.getHibernateTemplate().find("from Tenant");
	}
	
	@Override
	public Tenant save(Tenant tenant) {
		Integer pk=(Integer)this.getHibernateTemplate().save(tenant);
		return this.getHibernateTemplate().get(Tenant.class, pk);
	}
}
