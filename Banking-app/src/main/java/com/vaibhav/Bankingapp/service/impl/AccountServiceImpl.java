package com.vaibhav.Bankingapp.service.impl;


import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.Bankingapp.dto.AccountDto;
import com.vaibhav.Bankingapp.entity.Account;
import com.vaibhav.Bankingapp.mapper.AccountMapper;
import com.vaibhav.Bankingapp.repository.AccountRepository;
import com.vaibhav.Bankingapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	
	
	  
	public AccountServiceImpl(AccountRepository accountRepository) {
		
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount= accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount); 
	}



	@Override
	public AccountDto getAccountById(Long id) {
		// TODO Auto-generated method stub
		Account account= accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does Not Exists"));
		return AccountMapper.mapToAccountDto(account);
	}



	@Override
	public AccountDto deposit(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account= accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does Not Exists"));
		double total =account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto withdraw(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account= accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does Not Exists"));
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		double total=account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount =  accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts =accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
		.collect(Collectors.toList());
		
	}



	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		Account account= accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does Not Exists"));
		accountRepository.deleteById(id);
		
	} 
	

}
