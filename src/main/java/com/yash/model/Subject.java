package com.yash.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Subject")
public class Subject implements Serializable
{
	@Id
	@Column(name="ID")
	@GeneratedValue
	int id;
	
	@Column(name="Name")
	String name;
	
	@JsonIgnore
	@OneToMany(cascade= CascadeType.ALL,mappedBy = "sub")
	Set<Questions> que;
	
	public Subject() {}
	
	public Subject(int id, String name, Set<Questions> que) {
		
		this.id = id;
		this.name = name;
		this.que = que;
	}
	
	@JsonIgnore
	public Set<Questions> getQue() {
		return que;
	}
	
	@JsonIgnore
	public void setQue(Set<Questions> que) {
		this.que = que;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", que=" + que + "]";
	}
	

}
