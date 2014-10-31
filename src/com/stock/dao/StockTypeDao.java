package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.stock.dao.base.AbstractDao;
import com.stock.entity.StockType;

@Repository
public class StockTypeDao extends AbstractDao<StockType, Long> {

	protected Class<StockType> getClassType() {
		return StockType.class;
	}
	
	@Override
	public StockType baseMapper(ResultSet rs, int row) throws SQLException {
		StockType st = new StockType();
		st.setId(rs.getInt("S_T_ID"));
		st.setType(rs.getString("S_T_TYPE"));
		st.setText(rs.getString("S_T_TEXT"));
		return st;
	}

	@Override
	public StockType findById(StockType o) {
		return super.queryForObject("SELECT_STOCKTYPE", o.getId());
	}

	@Override
	public void save(StockType o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StockType o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StockType o) {
		// TODO Auto-generated method stub
		
	}

}
