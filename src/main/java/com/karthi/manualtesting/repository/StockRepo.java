package com.karthi.manualtesting.repository;

import java.util.List;

import com.karthi.manualtesting.model.Stock;

public interface StockRepo {

	public void save(Stock stock);

	public List<Stock> findAll();

	public void deleteById(int id);
	
	public void update(Stock stock);

	public Stock findById(int id);

	public List<String> findAllNames();

	public Stock findByName(String productName);

}
