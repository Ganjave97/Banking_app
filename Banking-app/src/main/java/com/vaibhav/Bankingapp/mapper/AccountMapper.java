package com.vaibhav.Bankingapp.mapper;

import com.vaibhav.Bankingapp.dto.AccountDto;
import com.vaibhav.Bankingapp.entity.Account;


public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountDto(
        		account.getId(), 
        		account.getAccountHolderName(), 
        		account.getBalance());
    }

    public static Account mapToAccount(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }
        return new Account(
        		accountDto.getId(), 
        		accountDto.getAccountHolderName(), 
        		accountDto.getBalance());
    }
}
