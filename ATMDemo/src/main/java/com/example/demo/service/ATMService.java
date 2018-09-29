package com.example.demo.service;

import com.example.demo.dto.Account;
import com.example.demo.exception.ATMException;

public interface ATMService {

    void createAccount(Account newAccount); 
    
    void deposit(Account account) throws ATMException;
    
    void withdraw(Account account) throws ATMException;
    
    Float getBalance(Integer accountNumber) throws ATMException;

}
