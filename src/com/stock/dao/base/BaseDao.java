package com.stock.dao.base;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.stock.entity.User;

public class BaseDao extends StockJDBCDao {
	
	
	
	public User getUserById(String id)
	{
		return super.getJdbcTemplate().queryForObject("SELECT * FROM USER WHERE U_ID = ?", new ParameterizedRowMapper<User>(){
			public User mapRow(ResultSet rs,int rowNum) throws SQLException{
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				return user;
			}
		},id);
	}
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.start();
		
		BaseDao stockDao = (BaseDao) context.getBean("baseDao");
		
		User user = stockDao.getUserById("100");
		
		if(user!=null)
		{
			System.out.println("Id = "+user.getId()+"\n"+"Name = "+user.getName());
		}
		context.stop();
		
	}
	
}
