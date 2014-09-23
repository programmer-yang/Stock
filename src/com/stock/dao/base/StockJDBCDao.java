package com.stock.dao.base;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockJDBCDao extends JdbcDaoSupport {

	@Autowired
	protected JdbcTemplate createJdbcTemplate(DataSource dataSource) {
		return super.createJdbcTemplate(dataSource);
	}

	
	
}
