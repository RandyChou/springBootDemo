package com.suishipen.springbootDemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Member {
	
	@Id
	@Column(length=36)
	@GeneratedValue(generator = "guid")
    @GenericGenerator(name = "guid", strategy = "guid")
	private String id;
	
	private String name;
	
	private int age;
	
	@Column(name="add_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addTime;

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
	
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date time) {
		this.addTime = time;
	}
	
}
