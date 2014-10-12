package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.stock.dao.base.BaseDao;
import com.stock.entity.Stock;
import com.stock.entity.User;
import com.stock.utils.Sqls;

@Repository
public class StockDao extends BaseDao<Stock, Long> {

	@Override
	protected Class<Stock> getClassType() {
		return Stock.class;
	}
	
	public Stock findById(String sql) {
		return null;
	}
	public void save(String sql) {
	}
	public void update(String sql) {
	}
	public void delete(String sql) {
	}
	
	/**
	 * 获取当前用户库存总数、用于计算比例、既：饼图数据
	 * SELECT U_ID,SUM(S_NUMBER_SUM) SUM,SUM(S_NUMBER_CUR) CUR FROM STOCK 
	 * WHERE U_ID = '100' AND S_VALID = '1' GROUP BY U_ID
	 * 
	 * 获取当前用户有效货物数量
	 * SELECT COUNT(1) NUMBER FROM STOCK WHERE U_ID = '100' AND S_VALID = '1';
	 */
	
	public Stock getStockNumberByUser(String userId,String valid,String sqlName)
	{
		
		String sql = Sqls.getSql(sqlName);
		Sqls.showPara(sqlName, userId,valid);
		return super.getJdbcTemplate().queryForObject( sql, new ParameterizedRowMapper<Stock>(){
			public Stock mapRow(ResultSet rs, int row) throws SQLException {
				Stock stock = new Stock();
				User user = new User();
				user.setId(rs.getInt("U_ID"));
				stock.setUser(user);
				stock.setNumberSum(rs.getString("SUM"));
				stock.setNumberCur(rs.getString("CUR"));
				return stock;
			}
			
		},userId,valid);
	}
	
	public Integer getStockSumByValid(String sqlName)
	{
		
		String sql = Sqls.getSql(sqlName);
		
		
		
		return null;
	}
	
	
	
	
	
	
	
}
