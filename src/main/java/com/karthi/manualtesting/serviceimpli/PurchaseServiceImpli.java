package com.karthi.manualtesting.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.manualtesting.model.Purchase;
import com.karthi.manualtesting.repository.PurchaseRepo;
import com.karthi.manualtesting.service.PurchaseService;

@Service
public class PurchaseServiceImpli implements PurchaseService{
	
	PurchaseRepo pRepo;
	
	public PurchaseServiceImpli(PurchaseRepo pRepo) {
		super();
		this.pRepo = pRepo;
	}
	
	public void savePurchase(Purchase purchase) {
		pRepo.save(purchase);
    }
	
	public void updatePurchase(Purchase purchase) {
		pRepo.update(purchase);
    }

	public List<Purchase> getAllPurchases() {
        return pRepo.findAll();
    }

    public Purchase getPurchaseById(int id) {
        return pRepo.findById(id);
    }

    public void deletePurchase(int id) {
    	pRepo.deleteById(id);
    }
}
