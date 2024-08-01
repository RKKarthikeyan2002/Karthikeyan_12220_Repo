package com.karthi.manualtesting.service;

import java.util.List;

import com.karthi.manualtesting.model.Stock;

public interface StockService {
	public String addStock(Stock stock);
	
	public String updateStock(Stock stock);
	
	public Stock getStockById(int id);
	
	public String deleteStock(int id);
	
	public List<Stock> getAllStocks();
	
	public List<String> getAllStockNames();
	
	public Stock getStockByProductName(String productName);
}
