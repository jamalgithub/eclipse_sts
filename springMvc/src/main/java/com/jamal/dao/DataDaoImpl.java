package com.jamal.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.jamal.domain.Employee;

@Repository
public class DataDaoImpl implements DataDao {
	  
	 private SessionFactory sessionFactory;  
	  
	 public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 
	 @Override
	public void insertRow(Employee employee) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  session.persist(employee);  
	 }  
	  
	 @SuppressWarnings("unchecked")
	@Override
	 public List<Employee> getList() {  
		  Session session = this.sessionFactory.getCurrentSession();
		  List<Employee> employeeList = session.createQuery("from Employee").list();  
		  return employeeList;  
	 }  
	  
	 @Override
	public Employee getRowById(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  Employee employee = (Employee) session.load(Employee.class, id);  
		  return employee;  
	 }  
	  
	 @Override
	public void updateRow(Employee employee) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  session.update(employee);  
	 }  
	  
	 @Override
	public void deleteRow(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  Employee employee = (Employee) session.load(Employee.class, id);  
		  session.delete(employee);  
	 }  

}
