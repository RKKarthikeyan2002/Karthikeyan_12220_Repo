package com.karthi.manualtesting.service;

import java.util.List;

import com.karthi.manualtesting.model.Purchase;

public interface PurchaseService {
	public void savePurchase(Purchase purchase);
	
	public void updatePurchase(Purchase purchase);
	
	public List<Purchase> getAllPurchases();
	
	public Purchase getPurchaseById(int id);
	
	public void deletePurchase(int id);
}
