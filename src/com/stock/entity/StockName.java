package com.stock.entity;

public class StockName {

	public StockName() {
	}
	
	public StockName(Integer id) {
		this.id = id;
	}

	private Integer id;
	private String name;
	private Integer StockTypeId;
	private StockType stockType;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StockType getStockType() {
		return stockType;
	}
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public Integer getStockTypeId() {
		return StockTypeId;
	}
	public void setStockTypeId(Integer stockTypeId) {
		StockTypeId = stockTypeId;
	}
	
	
}
