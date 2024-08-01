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

import com.karthi.manualtesting.model.Purchase;
import com.karthi.manualtesting.serviceimpli.PurchaseServiceImpli;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = { "http://localhost:3000/" })
public class PurchaseController {

	PurchaseServiceImpli purchaseServiceImpli;

	public PurchaseController(PurchaseServiceImpli purchaseServiceImpli) {
		super();
		this.purchaseServiceImpli = purchaseServiceImpli;
	}

	@PostMapping
	public void createPurchase(@RequestBody Purchase purchase) {
		purchaseServiceImpli.savePurchase(purchase);
	}

	@PutMapping
	public void editPurchase(@RequestBody Purchase purchase) {
		purchaseServiceImpli.updatePurchase(purchase);
	}

	@GetMapping("all")
	public List<Purchase> getAllPurchases() {
		return purchaseServiceImpli.getAllPurchases();
	}

	@GetMapping("{id}")
	public Purchase getPurchaseById(@PathVariable int id) {
		return purchaseServiceImpli.getPurchaseById(id);
	}

	@DeleteMapping("{id}")
	public void deletePurchase(@PathVariable int id) {
		purchaseServiceImpli.deletePurchase(id);
	}
}
