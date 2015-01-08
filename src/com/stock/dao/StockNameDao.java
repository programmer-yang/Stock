package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.stock.dao.base.AbstractDao;
import com.stock.entity.StockName;

@Repository
public class StockNameDao extends AbstractDao<StockName, Long> {
	
	@Override
	protected Class<StockName> getClassType() {
		return StockName.class;
	}

	@Override
	public StockName baseMapper(ResultSet rs, int row) throws SQLException {
		StockName sn = new StockName();
		sn.setId(rs.getInt("S_N_ID"));
		sn.setName(rs.getString("S_N_NAME"));
		sn.setStockTypeId(rs.getInt("S_T_ID"));
		
		return sn;
	}
	@Override
	public StockName findById(StockName o) {
		return super.queryForObject("SELECT_STOCKNAME", o.getId());
	}
	@Override
	public void save(StockName o) {
	}
	@Override
	public void update(StockName o) {
	}
	@Override
	public void delete(StockName o) {
	}

}
