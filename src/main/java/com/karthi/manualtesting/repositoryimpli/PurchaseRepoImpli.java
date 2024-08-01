package com.karthi.manualtesting.repositoryimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.manualtesting.model.Purchase;
import com.karthi.manualtesting.repository.PurchaseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PurchaseRepoImpli implements PurchaseRepo{
	EntityManager eManager;

	public PurchaseRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public void save(Purchase purchase) {
		eManager.persist(purchase);
	}

	@Override
	public void update(Purchase purchase) {
		eManager.merge(purchase);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> findAll() {
		String hql = "from Purchase";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Purchase findById(int id) {
		return eManager.find(Purchase.class, id);
	}

	@Override
	public void deleteById(int id) {
		Purchase purchase = eManager.find(Purchase.class, id);
		eManager.remove(purchase);
	}
}
