package com.jsf.sample.employeemanager.service;

import com.jsf.sample.employeemanager.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class EmployeeService {
	
	@PersistenceContext(unitName = "EmployeePU")
	/* private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU"); */
	
	/* private EntityManagerFactory emf; */
	
	   private EntityManager em;
	
	public List<Employee> findAll() {
		/* EntityManager em = emf.createEntityManager(); */
		 return em.createQuery("SELECT e from Employee e", Employee.class).getResultList();
	}
	
	@Transactional
	public void save(Employee employee) {
		/* EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); */
		if (employee.getId() == null) {
			em.persist(employee);
		} else {
			em.merge(employee);
		}
		/* em.getTransaction().commit();
		em.close(); */
	}
	
	@Transactional
	public void delete(Long id) {
	   /* EntityManager em = emf.createEntityManager();
	   em.getTransaction().begin(); */
	   Employee emp = em.find(Employee.class, id);
	   if (emp != null) {
		   em.remove(emp);
	   }
	   /* em.getTransaction().commit();
	   em.close(); */
	}

	public Employee findById(Long id) {
		return em.find(Employee.class,id);
	}
}	