package com.karthi.manualtesting.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.manualtesting.model.Stock;
import com.karthi.manualtesting.repository.StockRepo;
import com.karthi.manualtesting.service.StockService;

@Service
public class StockServiceImpli implements StockService{
	
	StockRepo sRepo;
		
	public StockServiceImpli(StockRepo sRepo) {
		super();
		this.sRepo = sRepo;
	}

	public List<Stock> getAllStocks() {
        return sRepo.findAll();
    }

    public Stock getStockById(int id) {
        return sRepo.findById(id);
    }

    public void addStock(Stock stock) {
    	sRepo.save(stock);
    }
    
    public void updateStock(Stock stock) {
    	sRepo.update(stock);
    }

    public void deleteStock(int id) {
    	sRepo.deleteById(id);
    }

	public List<String> getAllStockNames() {
		return sRepo.findAllNames();
	}

	public Stock getStockByProductName(String productName) {
		return sRepo.findByName(productName);
	}
}
