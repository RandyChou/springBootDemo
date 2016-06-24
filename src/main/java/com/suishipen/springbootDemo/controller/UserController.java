package com.suishipen.springbootDemo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suishipen.springbootDemo.dao.UserDao;
import com.suishipen.springbootDemo.model.Account;
import com.suishipen.springbootDemo.model.Info;
import com.suishipen.springbootDemo.model.Role;
import com.suishipen.springbootDemo.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public List<User> findAllUser() {
		List<User> users = userDao.findAll();
		return users;
	}
	
	@RequestMapping(value="/{userId}", method = RequestMethod.GET)
	public User findUserById(@PathVariable(value = "userId") String userId) {
		return userDao.findById(userId);
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public User add(@RequestBody User user) {
		Account account = new Account();
		account.setAmount(0);
		user.setAccount(account);
		return userDao.save(user);
	}
	
	@RequestMapping(value="", method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		User target = userDao.findById(user.getId());
		BeanUtils.copyProperties(user, target, "account", "infos", "roles");
		return userDao.save(target);
	}
	
	@RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
	public int delete(@PathVariable(value = "userId") String userId) {
		return userDao.deleteById(userId);
	}
	
	@RequestMapping(value="/{userId}/infos", method = RequestMethod.POST)
	public User addInfos(@PathVariable(value = "userId") String userId, @RequestBody List<Info> infos) {
		User user = userDao.findById(userId);
		user.addInfos(infos);
		return userDao.save(user);
	}
	
	@RequestMapping(value="/{userId}/info", method = RequestMethod.POST)
	public User addInfos(@PathVariable(value = "userId") String userId, @RequestBody Info info) {
		User user = userDao.findById(userId);
		user.addInfo(info);
		return userDao.save(user);
	}
	
	@RequestMapping(value="/{userId}/info", method = RequestMethod.PUT)
	public User deleteInfo(@PathVariable(value = "userId") String userId, @RequestBody Info info) {
		User user = userDao.findById(userId);
		user.removeInfo(info);
		return userDao.save(user);
	}
	
	@RequestMapping(value="/{userId}/infos", method = RequestMethod.PUT)
	public User deleteInfos(@PathVariable(value = "userId") String userId, @RequestBody List<Info> infos) {
		User user = userDao.findById(userId);
		user.removeInfos(infos);
		return userDao.save(user);
	}
	
	@RequestMapping(value="/{userId}/roles", method = RequestMethod.POST)
	public User addRoles(@PathVariable(value = "userId") String userId, @RequestBody List<Role> roles) {
		User user = userDao.findById(userId);
		user.addRoles(roles);
		return userDao.save(user);
	}
	
	@RequestMapping(value="/{userId}/role", method = RequestMethod.POST)
	public User addRole(@PathVariable(value = "userId") String userId, @RequestBody Role role) {
		User user = userDao.findById(userId);
		user.addRole(role);
		return userDao.save(user);
	}
	
	@RequestMapping(value="/{userId}/role", method = RequestMethod.PUT)
	public User deleteInfo(@PathVariable(value = "userId") String userId, @RequestBody Role role) {
		User user = userDao.findById(userId);
		user.removeRole(role);
		return userDao.save(user);
	}
	
	@RequestMapping(value="/{userId}/roles", method = RequestMethod.PUT)
	public User deleteRoles(@PathVariable(value = "userId") String userId, @RequestBody List<Role> roles) {
		User user = userDao.findById(userId);
		user.removeRoles(roles);
		return userDao.save(user);
	}
}
