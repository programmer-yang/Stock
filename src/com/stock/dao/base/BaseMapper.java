package com.stock.dao.base;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseMapper<T> {
	
	public abstract T baseMapper(ResultSet rs,int row) throws SQLException;
	
}
