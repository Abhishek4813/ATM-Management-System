package com.atm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atm.model.BankAccount;
import com.atm.model.History;
import com.atm.model.Transaction;
import com.atm.model.Users;
import com.atm.repository.AccountRepository;
import com.atm.repository.HistoryRepository;
import com.atm.repository.TransactionRepository;
import com.atm.repository.UserRepository;


@Repository
public class UserDAO {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public Users getUserByPin(Integer pin) {
		return userRepository.findByPin(pin);
	}
	
	public Users getById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public List<Transaction> getUsersTransactions(Long id){
		return  transactionRepository.findByUserId(id);
	}
	
	public List<History> getUsersHistory(Long id){
		return  historyRepository.findByUserId(id);
	}
	
	
	public BankAccount getBankDetails(Long userId, Long accountNumber) {
		return accountRepository.findByUserIdAndAccountNumber(userId,accountNumber);
	}
	
	public boolean updateAccountBalance(BankAccount account) {
		return accountRepository.save(account) !=null;
		
	}
	
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public History saveHistory(History history) {
		return historyRepository.save(history);
	}
}
