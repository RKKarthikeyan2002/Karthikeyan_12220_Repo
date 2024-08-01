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
	
	public String savePurchase(Purchase purchase) {
		try {
			pRepo.save(purchase);
			return "Success";
		} 
		catch (Exception e) {
			return "Failure";
		}
    }
	
	public String updatePurchase(Purchase purchase) {
        try {
            pRepo.update(purchase);
			return "Success";
		} 
		catch (Exception e) {
			return "Failure";
		}
    }

	public List<Purchase> getAllPurchases() {
        return pRepo.findAll();
    }

    public Purchase getPurchaseById(int id) {
        return pRepo.findById(id);
    }

    public String deletePurchase(int id) {
        try {
            pRepo.deleteById(id);
			return "Success";
		} 
		catch (Exception e) {
			return "Failure";
		}
    }
}
