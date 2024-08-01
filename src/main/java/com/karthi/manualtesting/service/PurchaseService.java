package com.karthi.manualtesting.service;

import java.util.List;

import com.karthi.manualtesting.model.Purchase;

public interface PurchaseService {
	public String savePurchase(Purchase purchase);
	
	public String updatePurchase(Purchase purchase);
	
	public List<Purchase> getAllPurchases();
	
	public Purchase getPurchaseById(int id);
	
	public String deletePurchase(int id);
}
