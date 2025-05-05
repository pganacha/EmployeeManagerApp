package com.jsf.sample.employeemanager.controller;

import com.jsf.sample.employeemanager.model.Employee;
import com.jsf.sample.employeemanager.service.EmployeeService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.io.IOException;
import java.util.List;


@Named
@SessionScoped
public class EmployeeController implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Employee> employees;
	private Employee currentEmployee;
	/* private Employee currentEmployee = new Employee(); */
	/* private EmployeeService employeeService = new EmployeeService(); */
	
	@Inject
	private EmployeeService employeeService;
	
	@PostConstruct
	public void init() {
		employees = employeeService.findAll();
		
		if (employees == null || employees.isEmpty()) {
			currentEmployee = new Employee();
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("edit.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public String save() {
		employeeService.save(currentEmployee);
		employees = employeeService.findAll();
		currentEmployee = new Employee();
		return "list.xhtml?faces-redirect=true";
	}
	
	public void edit(Employee employee) {
		this.currentEmployee = employee;
	}

    public void delete(Employee employee) {
		employeeService.delete(employee.getId());
		employees = employeeService.findAll();
	}

    public List<Employee> getEmployees() {
         return employees;		
	}
	
	public Employee getCurrentEmployee() {
		return currentEmployee;
	}

    public void setCurrentEmployee(Employee currentEmployee) {
         this.currentEmployee = currentEmployee;
    }		 
	
}