package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.StockTypeDao;
import com.stock.entity.StockType;
import com.stock.service.base.AbstractService;

@Service
public class StockTypeService extends AbstractService<StockType, Long> {

	private StockTypeDao stDao;

	public StockTypeDao getStDao() {
		return stDao;
	}
	
	@Autowired
	public void setStDao(StockTypeDao stDao) {
		this.setBaseDao(stDao);
		this.stDao = stDao;
	}
	
	
	
}
