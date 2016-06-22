package com.suishipen.springbootDemo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=32)
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	
	@Column(length=45)
	private String name;
	
	private int age;
	
	@Enumerated
	private Sex sex;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Account account;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Info> infos = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Role> roles = new ArrayList<>();
	
	private static enum Sex {
		MALE,
		FEMALE
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		account.setUser(this);
		this.account = account;
	}

	public List<Info> getInfos() {
		return infos;
	}

	public void setInfos(List<Info> infos) {
		this.infos.clear();
		for(Info info : infos) {
			info.setUser(this);
		}
		this.infos.addAll(infos);
	}
	
	public void addInfo(Info info) {
		this.infos.size();
		info.setUser(this);
		this.infos.add(info);
	}
	
	public void addInfos(List<Info> infos) {
		this.infos.size();
		for(Info info : infos) {
			info.setUser(this);
		}
		this.infos.addAll(infos);
	}
	
	public void removeInfo(Info info) {
		for(Info i : this.infos) {
			if(i.getId().equals(info.getId())) {
				info = i;
				break;
			}
		}
		this.infos.remove(info);
	}
	
	public void removeInfos(List<Info> infos) {
		List<Info> tmp = new ArrayList<>();
		for(Info i : this.infos) {
			for(Info j : infos) {
				if(i.getId().equals(j.getId())) {
					tmp.add(i);
					break;
				}
			}
		}
		if(tmp.size() > 0) {
			this.infos.removeAll(tmp);
		}
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles.clear();
		for(Role role : roles) {
			role.getUsers().add(this);
		}
		this.roles.addAll(roles);
	}
	
	public void addRole(Role role) {
		role.getUsers().add(this);
		this.roles.add(role);
	}
	
	public void addRoles(List<Role> roles) {
		for(Role role : roles) {
			role.getUsers().add(this);
		}
		this.roles.addAll(roles);
	}
	
	public void removeRole(Role role) {
		for(Role r : this.roles) {
			if(r.getId().equals(role.getId())) {
				role = r;
				break;
			}
		}
		
		this.roles.remove(role);
	}
	
	public void removeRoles(List<Role> roles) {
		List<Role> tmp = new ArrayList<>();
		for(Role r : this.roles) {
			for(Role r1 : roles) {
				if(r.getId().equals(r1.getId())) {
					tmp.add(r);
					break;
				}
			}
		}
		this.roles.removeAll(tmp);
	}
}
