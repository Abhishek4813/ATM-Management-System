package com.atm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atm.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long>{
	
	public List<Transaction> findByUserId(Long id);
}
