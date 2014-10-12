package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.StockDao;
import com.stock.entity.Stock;

@Service
public class StockService  {
	
	@Autowired
	private StockDao stockDao;

	public Stock getStockNumberByUser(String userId,String valid,String sqlName)
	{
		return stockDao.getStockNumberByUser(userId, valid, sqlName);
	}
	
}
