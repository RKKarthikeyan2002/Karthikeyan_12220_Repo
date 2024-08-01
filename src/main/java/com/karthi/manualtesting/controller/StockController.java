package com.karthi.manualtesting.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.manualtesting.model.Stock;
import com.karthi.manualtesting.serviceimpli.StockServiceImpli;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = { "http://localhost:3000/" })
public class StockController {
	StockServiceImpli stockServiceImpli;

	public StockController(StockServiceImpli stockServiceImpli) {
		super();
		this.stockServiceImpli = stockServiceImpli;
	}

	@PostMapping
	public void createStock(@RequestBody Stock stock) {
		stockServiceImpli.addStock(stock);
	}

	@PutMapping
	public void editStock(@RequestBody Stock stock) {
		stockServiceImpli.updateStock(stock);
	}

	@GetMapping("/all")
	public List<Stock> getAllStocks() {
		return stockServiceImpli.getAllStocks();
	}
	
	@GetMapping("/productname")
	public List<String> getAllStockNames() {
		return stockServiceImpli.getAllStockNames();
	}
	
	@GetMapping("{productName}")
	public Stock getStockByName(@PathVariable String productName) {
		return stockServiceImpli.getStockByProductName(productName);
	}
	
	@GetMapping("/getStock/{id}")
	public Stock getStockById(@PathVariable int id) {
		return stockServiceImpli.getStockById(id);
	}

	@DeleteMapping("{id}")
	public void deleteStock(@PathVariable int id) {
		stockServiceImpli.deleteStock(id);
	}
}
