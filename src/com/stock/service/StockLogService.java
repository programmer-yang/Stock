package com.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.StockLogDao;
import com.stock.entity.StockLog;
import com.stock.service.base.AbstractService;
@Service
public class StockLogService extends AbstractService<StockLog, Long> {

	@Autowired
	private StockLogDao slDao;
	
	public List<StockLog> getStockLogListById(StockLog	stockLog)
	{
		return slDao.getStockLogListByUserId(stockLog); 
	}
	
}
