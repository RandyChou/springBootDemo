package com.suishipen.springbootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.suishipen.springbootDemo.model.User;

@Transactional
public interface UserDao extends JpaRepository<User, String> {
	public User findById(String id);
	public int deleteById(String id);
}
