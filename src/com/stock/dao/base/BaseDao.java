package com.stock.dao.base;

public abstract class BaseDao<T,PK> extends StockJDBCDao {
	
	protected abstract Class<T> getClassType();
	
	public abstract T findById(String sql);
	
	public abstract void save(String sql);
	
	public abstract void update(String sql);
	
	public abstract void delete(String sql);
	
}
