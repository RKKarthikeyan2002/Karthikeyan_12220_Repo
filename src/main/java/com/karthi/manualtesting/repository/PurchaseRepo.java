package com.karthi.manualtesting.repository;

import java.util.List;

import com.karthi.manualtesting.model.Purchase;

public interface PurchaseRepo {

	public void save(Purchase purchase);

	public void update(Purchase purchase);

	public List<Purchase> findAll();

	public Purchase findById(int id);

	public void deleteById(int id);

}
