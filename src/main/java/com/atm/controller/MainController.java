package com.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.atm.exceptions.AuthorizationException;
import com.atm.exceptions.BankAccountNotFoundException;
import com.atm.exceptions.IdNotFoundException;
import com.atm.model.History;
import com.atm.model.Transaction;
import com.atm.model.WithdrawRequest;
import com.atm.service.TokenFetch;
import com.atm.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	TokenFetch tokenFetch;
	
	@Autowired
	UserService userService;
	
	/*
	 * {"userId":1001, "accountNumber":100000001, "amount":100000 }
	 */

	@PostMapping("/withdraw")
	public ResponseEntity<History> withdrawAmount(@RequestHeader("Authorization") String  header, @RequestBody WithdrawRequest withdrawRequest) 
	throws AuthorizationException, MissingRequestHeaderException, BankAccountNotFoundException{
		
		if(tokenFetch.authorizeToken(header)) {
			
			History transaction= userService.makeTransaction(withdrawRequest);	
			return ResponseEntity.status(HttpStatus.OK).body(transaction);
		}
		else
			throw new AuthorizationException("Unauthorized Access");	
	}
	
	/*
	 * localhost:8081/transaction/1001
	 */
	
	@GetMapping("/transaction/{id}")
	public ResponseEntity<List<Transaction>> getAUserAllTransaction(@RequestHeader("Authorization") String header, @PathVariable("id") Long id )
	throws AuthorizationException, MissingRequestHeaderException,IdNotFoundException, MethodArgumentTypeMismatchException{
		
		if(tokenFetch.authorizeToken(header)) {
			List<Transaction> transactions=userService.getUserTransactions(id);
			return ResponseEntity.status(HttpStatus.OK).body(transactions);
		}
		else
			throw new AuthorizationException("Unauthorized Access");
	}
	
	/*
	 * localhost:8081/history/1001
	 */
	
	@GetMapping("/history/{id}")
	public ResponseEntity<List<History>> getUserAllHistory(@RequestHeader("Authorization") String header, @PathVariable("id") Long id )
	throws AuthorizationException, MissingRequestHeaderException, MethodArgumentTypeMismatchException,IdNotFoundException{
		
		if(tokenFetch.authorizeToken(header)) {
			List<History> history=userService.getUserHistory(id);
			return ResponseEntity.status(HttpStatus.OK).body(history);
		}
		else
			throw new AuthorizationException("Unauthorized Access");
	}
}
