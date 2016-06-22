package com.suishipen.springbootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suishipen.springbootDemo.model.Member;

public interface MemberDao extends JpaRepository<Member, String> {

}
