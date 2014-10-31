package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.stock.dao.base.AbstractDao;
import com.stock.dao.base.BaseMapper;
import com.stock.entity.Stock;
import com.stock.entity.User;

@Repository
public class StockDao extends AbstractDao<Stock, Long> {

	@Override
	protected Class<Stock> getClassType() {
		return Stock.class;
	}
	
	
	
	@Override
	public Stock baseMapper(ResultSet rs, int row) throws SQLException {
		Stock stock = new Stock();
		stock.setId(rs.getInt("S_ID"));
		stock.setStockNameId(rs.getInt("S_N_ID"));
		stock.setUserId(rs.getInt("U_ID"));
		stock.setNumberSum(rs.getFloat("S_NUMBER_SUM")+"");
		stock.setNumberCur(rs.getFloat("S_NUMBER_CUR")+"");
		stock.setDataType(rs.getInt("S_DATA_TYPE"));
		stock.setTime(rs.getString("S_TIME"));
		stock.setValid(rs.getInt("S_VALID"));
		
		return stock;
	}
	
	/**
	 * 通过id获取库存完整信息
	 */
	public Stock findById(Stock o) {
		return super.queryForObject("SELECT_STOCK", o.getId().toString());
	}
	
	public void save(Stock o) 
	{
	}
	public void update(Stock o) 
	{
	}
	public void delete(Stock o) 
	{
	}
	
	/**
	 * 获取当前用户库存总数、用于计算比例、既：饼图数据
	 * SELECT U_ID,SUM(S_NUMBER_SUM) SUM,SUM(S_NUMBER_CUR) CUR FROM STOCK 
	 * WHERE U_ID = '100' AND S_VALID = '1' GROUP BY U_ID
	 * 
	 * 获取当前用户有效货物数量
	 * SELECT COUNT(1) NUMBER FROM STOCK WHERE U_ID = '100' AND S_VALID = '1';
	 */
	
	public Stock getStockSumByUser(Stock o)
	{
		return super.queryForObject("SELECT_STOCK_SUM", new BaseMapper<Stock>(){
			public Stock baseMapper(ResultSet rs, int row) throws SQLException {
				Stock stock = new Stock();
				User user = new User();
				user.setId(rs.getInt("U_ID"));
				stock.setUser(user);
				stock.setNumberSum(rs.getString("SUM"));
				stock.setNumberCur(rs.getString("CUR"));
				return stock;
			}
			
		},o.getUser().getId(),o.getValid());
	}
	
	public Integer getStockCountByValid(Stock o)
	{
		return super.queryForInt("SELECT_STOCK_COUNT",o.getUser().getId(),o.getValid());
		
	}

}
