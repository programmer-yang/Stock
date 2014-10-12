package com.stock.service.base;

import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.base.BaseDao;

@Transactional(readOnly = true)
public abstract class AbstractService<T,PK> {

	
	private BaseDao<T, PK> baseDao;
	
	public BaseDao<T,PK> getBaseDao()
	{
		return baseDao;
	}
	
	public void setBaseDao(BaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}


	@Transactional(readOnly = false)
	public T findById(String sql)
	{
		return getBaseDao().findById(sql);
	}
	
	@Transactional(readOnly = false)
	public void save(String sql)
	{
		getBaseDao().save(sql);
	}
	
	@Transactional(readOnly = false)
	public void update(String sql)
	{
		getBaseDao().update(sql);
	}
	
	@Transactional(readOnly = false)
	public void delete(String sql)
	{
		getBaseDao().delete(sql);
	}
	
}
