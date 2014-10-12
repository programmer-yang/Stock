package com.stock.dao.base;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockJDBCDao extends JdbcDaoSupport {

	@Resource(name = "dataSource")
	public void setSuperDataSource(DataSource dataSource)
	{
		super.setDataSource(dataSource);
	}
	
	
	
}
