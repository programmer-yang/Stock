package com.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.StockDao;
import com.stock.entity.Stock;
import com.stock.entity.User;
import com.stock.service.base.AbstractService;

@Service
public class StockService extends AbstractService<Stock, Long> {
	
	private StockDao stockDao;

	public StockDao getStockDao() {
		return stockDao;
	}

	@Autowired
	public void setStockDao(StockDao stockDao) {
		this.setBaseDao(stockDao);
		this.stockDao = stockDao;
	}


	public Stock getStockSumByUser(Stock stock)
	{
		return stockDao.getStockSumByUser(stock);
	}
	
	
	public Integer getStockCountByValid(Stock stock)
	{
		return stockDao.getStockCountByValid(stock);
	}
	
	public List<Stock> getStocksByUser(User u )
	{
		return stockDao.getStocksByUser(u);
	}
	
	
	
}
