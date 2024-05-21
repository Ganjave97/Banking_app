package com.vaibhav.Bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.Bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository <Account, Long> {

}
