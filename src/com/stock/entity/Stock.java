package com.stock.entity;

public class Stock {

	private Integer Id;
	private StockName stockName;
	private User user;
	private Integer numberSum;
	private Integer numberCur;
	private Integer dataType;
	private String time;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public StockName getStockName() {
		return stockName;
	}
	public void setStockName(StockName stockName) {
		this.stockName = stockName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getNumberSum() {
		return numberSum;
	}
	public void setNumberSum(Integer numberSum) {
		this.numberSum = numberSum;
	}
	public Integer getNumberCur() {
		return numberCur;
	}
	public void setNumberCur(Integer numberCur) {
		this.numberCur = numberCur;
	}
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
