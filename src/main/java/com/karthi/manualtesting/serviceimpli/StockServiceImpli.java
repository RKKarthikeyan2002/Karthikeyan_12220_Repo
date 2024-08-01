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

    public String addStock(Stock stock) {
    	try {
    		sRepo.save(stock);
    		return "Success";
		} 
    	catch (Exception e) {
			return "Failure";
		}
    }
    
    public String updateStock(Stock stock) {
        try {
            sRepo.update(stock);
    		return "Success";
		} 
    	catch (Exception e) {
			return "Failure";
		}
    }

    public String deleteStock(int id) {
        try {
            sRepo.deleteById(id);
    		return "Success";
		} 
    	catch (Exception e) {
			return "Failure";
		}
    }

	public List<String> getAllStockNames() {
		return sRepo.findAllNames();
	}

	public Stock getStockByProductName(String productName) {
		return sRepo.findByName(productName);
	}
}
