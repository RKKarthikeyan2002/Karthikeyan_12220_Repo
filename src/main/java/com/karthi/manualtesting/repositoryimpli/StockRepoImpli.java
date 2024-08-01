package com.karthi.manualtesting.repositoryimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.manualtesting.model.Stock;
import com.karthi.manualtesting.repository.StockRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StockRepoImpli implements StockRepo {
	
	EntityManager eManager;
	
	public StockRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public void save(Stock stock) {
		eManager.persist(stock);
	}

	@Override
	public void update(Stock stock) {
		eManager.merge(stock);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> findAll() {
		String hql = "from Stock";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void deleteById(int id) {
		Stock stock = eManager.find(Stock.class, id);
		eManager.remove(stock);
	}

	@Override
	public Stock findById(int id) {
		return eManager.find(Stock.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllNames() {
		String hql = "select productName from Stock";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Stock findByName(String productName) {
		String hql = "select s from Stock s where productName = :name";
		Query query = eManager.createQuery(hql).setParameter("name", productName);
		return (Stock) query.getSingleResult();
	}

}
