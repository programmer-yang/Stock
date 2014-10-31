package com.stock.entity;

public class Stock {

	public Stock() {
	}
	
	public Stock(Integer id) {
		this.id = id;
	}

	private Integer id;
	private Integer stockNameId;
	private StockName stockName;
	private Integer userId;
	private User user;
	private String numberSum;
	private String numberCur;
	private Integer dataType;
	private String time;
	private Integer valid;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getNumberSum() {
		return numberSum;
	}
	public void setNumberSum(String numberSum) {
		this.numberSum = numberSum;
	}
	public String getNumberCur() {
		return numberCur;
	}
	public void setNumberCur(String numberCur) {
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
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public Integer getStockNameId() {
		return stockNameId;
	}
	public void setStockNameId(Integer stockNameId) {
		this.stockNameId = stockNameId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String toString() {
		return id+":"+stockNameId+":"+userId;
	}
	
	
	
	
	
	
}
