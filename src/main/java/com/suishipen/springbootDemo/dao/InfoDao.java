package com.suishipen.springbootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suishipen.springbootDemo.model.Info;

public interface InfoDao extends JpaRepository<Info, String> {

}
