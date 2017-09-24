package com.jamal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jamal.dao.DataDao;
import com.jamal.domain.Employee;

public class DataServiceImpl implements DataService {

	 @Autowired 
	 DataDao dataDao;  
	  	   
	 @Transactional
	 public void insertRow(Employee employee) {  
		 dataDao.insertRow(employee);  
	 }  
	  
	 @Transactional
	 public List<Employee> getList() {  
	  return dataDao.getList();  
	 }  
	  
	 @Transactional
	 public Employee getRowById(int id) {  
	  return dataDao.getRowById(id);  
	 }  
	  
	 @Transactional
	 public void updateRow(Employee employee) {  
		 dataDao.updateRow(employee);  
	 }  
	  
	 @Transactional
	 public void deleteRow(int id) {  
		 dataDao.deleteRow(id);  
	 }  

}
