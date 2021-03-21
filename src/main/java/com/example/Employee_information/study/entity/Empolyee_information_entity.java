package com.example.Employee_information.study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity(name = "Employee_Information")
public class Empolyee_information_entity {
	
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@Column(name = "Emp_name")
	private String Name;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name="From_city")
	private String from;
	
	@Column(name = "to_city")
	private String to;
	
	public Empolyee_information_entity(Integer id, String name, String status, String from, String to) {
		super();
		this.id = id;
		Name = name;
		this.status = status;
		this.from = from;
		this.to = to;
	}
	
	public Empolyee_information_entity() 
	{
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Empolyee_information_entity [id=" + id + ", Name=" + Name + ", status=" + status + ", from=" + from
				+ ", to=" + to + "]";
	}
	

	
	
}
