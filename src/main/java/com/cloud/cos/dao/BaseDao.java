package com.cloud.cos.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

public class BaseDao<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {

	@Override
	@Autowired
	@Resource(name = "sessionFactory")  
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
