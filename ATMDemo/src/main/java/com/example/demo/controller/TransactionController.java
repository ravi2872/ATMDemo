package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Account;
import com.example.demo.exception.ATMException;
import com.example.demo.service.ATMService;

@RestController
@RequestMapping("")
@Transactional
public class TransactionController {
	
	@Autowired
	public ATMService atmService;
	
	@PostMapping(path = "/createAccount", consumes = "application/json", produces = "application/json")
	public ResponseEntity<HttpStatus> createAccount(@RequestBody Account newAccount){
		atmService.createAccount(newAccount);
		return ResponseEntity.ok(HttpStatus.OK);
		
	}
    
	@PostMapping(path = "/deposit", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> deposit(@RequestBody Account account) throws ATMException{
		atmService.deposit(account);
    	return ResponseEntity.ok(HttpStatus.OK);
    }
    
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> withdraw(@RequestBody Account account) throws ATMException{
		atmService.withdraw(account);
    	return ResponseEntity.ok(HttpStatus.OK);
    }
    
	@RequestMapping(value = "/getbalance/{accountNumber}", method = RequestMethod.GET)
    public ResponseEntity<Float> getBalance(@PathVariable("accountNumber") String accountNumber) throws ATMException{
		Float balance = atmService.getBalance(Integer.valueOf(accountNumber));
    	return ResponseEntity.ok(balance);
    }
	
}
