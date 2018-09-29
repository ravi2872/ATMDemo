package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Account;
import com.example.demo.exception.ATMException;
import com.example.demo.service.ATMService;

@Service
public class ATMServiceImpl implements ATMService {

	private final static ArrayList<Account> accounts = new ArrayList<>(
			Arrays.asList(new Account(11111, Float.valueOf(1234f)), new Account(22222, Float.valueOf(1500.00f)),
					new Account(11111, Float.valueOf(1234f)), new Account(33333, Float.valueOf(2500.00f)),
					new Account(44444, Float.valueOf(25000.00f))));

	@Override
	public void createAccount(final Account newAccount) {
		accounts.add(new Account(newAccount.getAccoountNumber(), newAccount.getBalance()));
	}

	@Override
	public void deposit(final Account account) throws ATMException {
		Optional<Account> optionalAccount = accounts.stream().filter(acc -> account.getAccoountNumber().equals(acc.getAccoountNumber())).findAny();
		if(optionalAccount.isPresent()){
			Account myAccount = optionalAccount.get();
			Float newBalance = myAccount.getBalance() + account.getBalance();
			myAccount.setBalance(newBalance);
		}else{
			throw new ATMException("Account Not Found");
		}
	}

	@Override
	public void withdraw(final Account account) throws ATMException {
		Optional<Account> optionalAccount = accounts.stream().filter(acc -> account.getAccoountNumber().equals(acc.getAccoountNumber())).findAny();
		if(optionalAccount.isPresent()){
			Account myAccount = optionalAccount.get();
			if(myAccount.getBalance().compareTo(account.getBalance()) == -1){
				throw new ATMException("Insufficient Funds");
			}
			Float newBalance = myAccount.getBalance() - account.getBalance();
			myAccount.setBalance(newBalance);
		}else{
			throw new ATMException("Account Not Found");
		}
		
	}

	@Override
	public Float getBalance(final Integer accountNumber)  throws ATMException{
		Optional<Account> optionalAccount = accounts.stream().filter(acc -> accountNumber.equals(acc.getAccoountNumber())).findAny();
		if(optionalAccount.isPresent()){
			Account myAccount = optionalAccount.get();
			return myAccount.getBalance();
		}else{
			throw new ATMException("Account Not Found");
		}
	}
	
}
