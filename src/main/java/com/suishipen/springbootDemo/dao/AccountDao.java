package com.suishipen.springbootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suishipen.springbootDemo.model.Account;

public interface AccountDao extends JpaRepository<Account, String> {

}
