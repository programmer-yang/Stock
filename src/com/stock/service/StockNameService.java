package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.StockNameDao;
import com.stock.entity.StockName;
import com.stock.service.base.AbstractService;

@Service
public class StockNameService extends AbstractService<StockName, Long> {

	private StockNameDao snDao;

	public StockNameDao getSnDao() {
		return snDao;
	}
	
	@Autowired
	public void setSnDao(StockNameDao snDao) {
		this.setBaseDao(snDao);
		this.snDao = snDao;
	}
	
	
	
}
