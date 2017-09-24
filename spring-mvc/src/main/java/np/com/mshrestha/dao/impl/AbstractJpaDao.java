/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package np.com.mshrestha.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import np.com.mshrestha.dao.Dao;

import org.springframework.util.ReflectionUtils;


// Don't put @Transactional here. It's not that it's inherently wrong--indeed it would allow us to avoid some pass-
// though service bean methods--but using @Transactional causes Spring to create proxies, and recipe 10.3 assumes that
// it has direct access to the DAOs. I don't think we're doing direct DAO injects into controllers anywhere. [WLW]

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public abstract class AbstractJpaDao<T extends Object> implements Dao<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> domainClass;
	
	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
	    if (domainClass == null) {
	    	ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
	        this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
	    }
	    return domainClass;
	}
	
	private String getDomainClassName() { 
		return getDomainClass().getName(); 
	}
		
	@Override
	public void create(T t) {
		
		// If there's a setDateCreated() method, then set the date.
		Method method = ReflectionUtils.findMethod(getDomainClass(), "setDateCreated", new Class[] { Date.class });
		if (method != null) {
			try {
				method.invoke(t, new Date());
			} catch (Exception e) {
				// Ignore any exception here; simply abort the setDate() attempt
			}
		}		
		entityManager.merge(t);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return entityManager.find(getDomainClass(), id);
	}	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return entityManager.createQuery("from " + getDomainClassName()).getResultList();
	}
		
	@Override
	public void update(T t) { 
		entityManager.merge(t); 
	}
		
	@Override
	public void delete(T t) { 		
		if (null != t) {
			entityManager.remove(t);
		}		
	}
		
	@Override
	public void deleteById(Serializable id) {
		T t= load(id);
		delete(t);		
	}
	
	@Override
	public void deleteAll() {
		entityManager.createQuery("delete " + getDomainClassName()).executeUpdate();
	}
		
	@Override
	public long count() {
		return (Long) entityManager.createQuery("select count(*) from " + getDomainClassName()).getSingleResult();
	}
		
	@Override
	public boolean exists(Serializable id) { 
		return (get(id) != null); 
	}
}