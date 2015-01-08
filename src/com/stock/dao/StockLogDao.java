package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.stock.dao.base.AbstractDao;
import com.stock.entity.StockLog;

@Repository
public class StockLogDao extends AbstractDao<StockLog, Long> {

	@Override
	public StockLog baseMapper(ResultSet rs, int row) throws SQLException {
		
		StockLog stockLog = new StockLog();
		stockLog.setId(rs.getInt("S_L_ID"));
		stockLog.setStockId(rs.getInt("S_ID"));
		stockLog.setNumber(rs.getFloat("S_L_NUMBER")+"");
		stockLog.setTime(rs.getString("S_L_TIME"));
		
		return stockLog;
	}

	@Override
	protected Class<StockLog> getClassType() {
		return StockLog.class;
	}

	@Override
	public StockLog findById(StockLog o) {
		return super.queryForObject("SELECT_STOCKLOG", o.getId());
	}

	@Override
	public void save(StockLog o) {
	}

	@Override
	public void update(StockLog o) {
	}

	@Override
	public void delete(StockLog o) {
	}
	
	public List<StockLog> getStockLogListByUserId(StockLog	stockLog) {
		return super.queryForObjectList("SELECT_STOCKLOG_LIST", stockLog.getStock().getUserId(),stockLog.getTime());
	}
	
	

}
