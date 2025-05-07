package com.jsf.sample.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String position;
	private Double salary;
	
	//Getters & Setters
	public Long getId() { 
	  return id;
	}

    public void setId(Long id) {
		this.id=id;
	}

    public String getName() {
       return name;
	}
    
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Double getSalary() {
		return salary;
	}

    public void setSalary(Double salary) {
       this.salary = salary;
    }	   

}	