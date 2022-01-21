package com.atm.repository;

import org.springframework.data.repository.CrudRepository;

import com.atm.model.BankAccount;

public interface AccountRepository extends CrudRepository<BankAccount,Long>  {
	
	BankAccount findByUserIdAndAccountNumber(Long userId,Long accountNumber);

}
