package com.stock.service.base;

import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.base.AbstractDao;

@Transactional(readOnly = true)
public abstract class AbstractService<T,PK> {

	
	private AbstractDao<T, PK> baseDao;
	
	public AbstractDao<T,PK> getBaseDao()
	{
		return baseDao;
	}
	
	public void setBaseDao(AbstractDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}


	@Transactional(readOnly = false)
	public T findById(T o)
	{
		return getBaseDao().findById(o);
	}
	
	@Transactional(readOnly = false)
	public void save(T o)
	{
		getBaseDao().save(o);
	}
	
	@Transactional(readOnly = false)
	public void update(T o)
	{
		getBaseDao().update(o);
	}
	
	@Transactional(readOnly = false)
	public void delete(T o)
	{
		getBaseDao().delete(o);
	}
	
}
