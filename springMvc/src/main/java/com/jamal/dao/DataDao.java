package com.jamal.dao;

import java.util.List;

import com.jamal.domain.Employee;

public interface DataDao {
	 public void insertRow(Employee employee);  
	  
	 public List<Employee> getList();  
	  
	 public Employee getRowById(int id);  
	  
	 public void updateRow(Employee employee);  
	  
	 public void deleteRow(int id);  
}
