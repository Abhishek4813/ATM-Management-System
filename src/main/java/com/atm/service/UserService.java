package com.atm.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.dao.UserDAO;
import com.atm.exceptions.BankAccountNotFoundException;
import com.atm.exceptions.IdNotFoundException;
import com.atm.model.BankAccount;
import com.atm.model.History;
import com.atm.model.Transaction;
import com.atm.model.Users;
import com.atm.model.WithdrawRequest;

@Service
public class UserService{

	@Autowired
	UserDAO userDao;
	
	SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Users getUserDetails(Integer pin) {
		return userDao.getUserByPin(pin);
	}
	
	public List<Transaction> getUserTransactions(Long id) throws IdNotFoundException{
		List<Transaction>list= userDao.getUsersTransactions(id);
		if(list.isEmpty())
			throw new IdNotFoundException("No Transaction Avaliable With this Id");
		return list;
	}
	
	public List<History> getUserHistory(Long id) throws IdNotFoundException{
		List<History> list= userDao.getUsersHistory(id);
		if(list.isEmpty())
			throw new IdNotFoundException("User Do Not Have any Transaction History");
		return list;
	}
	
	public History makeTransaction(WithdrawRequest withdraw)
	throws BankAccountNotFoundException{
		Transaction transaction = new Transaction();
		History history= new History();
		BankAccount account=userDao.getBankDetails(withdraw.getUserId(), withdraw.getAccountNumber());
		if(account==null)
			throw new BankAccountNotFoundException("Check you have Entered valid Account Number and User Id");
		Users user=userDao.getById(withdraw.getUserId());
		
		Double balance=account.getAvailableBalance();
		String status="Failed";
		Double debitAmount=0.0;
		
		if(account.getAvailableBalance()>=withdraw.getAmount()) {
			balance=account.getAvailableBalance()-withdraw.getAmount();
			String transactionTime=formatter.format(new Date());
			account.setAvailableBalance(balance);
			userDao.updateAccountBalance(account);
			
			transaction.setUserId(withdraw.getUserId());
			transaction.setAccountNumber(withdraw.getAccountNumber());
			transaction.setUserName(user.getFirstname()+" "+user.getLastname());
			transaction.setAmountDebited(withdraw.getAmount());
			transaction.setTransactionDate(transactionTime);
			
			status="Completed";
			debitAmount=withdraw.getAmount();
			userDao.saveTransaction(transaction);
		}
			
		history.setUserId(withdraw.getUserId());
		history.setAccountNumber(withdraw.getAccountNumber());
		history.setUserName(user.getFirstname()+" "+user.getLastname());
		history.setAmountDebited(debitAmount);
		history.setRemainingBalance(balance);
		history.setTransactionType("Debit");
		history.setTransactionStatus(status);
		history.setTransactionDate(formatter.format(new Date()));
		
		userDao.saveHistory(history);
		return history;		
	}
}
