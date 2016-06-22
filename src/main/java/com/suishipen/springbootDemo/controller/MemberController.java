package com.suishipen.springbootDemo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suishipen.springbootDemo.dao.MemberDao;
import com.suishipen.springbootDemo.model.Member;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value="", method = RequestMethod.GET)
	public List<Member> findAllMember() {
		return memberDao.findAll();
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public Member add(@RequestBody Member member) {
		member.setAddTime(new Date());
		return memberDao.save(member);
	}
}
