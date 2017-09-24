package np.com.mshrestha.bookstore.service.impl;

import java.util.List;

import np.com.mshrestha.bookstore.dao.EmployeeDao;
import np.com.mshrestha.bookstore.model.Employee;
import np.com.mshrestha.bookstore.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	 @Autowired 
	 EmployeeDao employeeDao;
	 
	 @Override
	 @Transactional
	 public void insertEmployee(Employee employee) {  
		 employeeDao.insertEmployee(employee);  
	 }
	 
	 @Override
	 @Transactional(readOnly = true)
	 public List<Employee> getList() {  
		 return employeeDao.getList();  
	 }
	 
	 @Override
	 @Transactional(readOnly = true)
	 public Employee getEmployeeById(int id) {  
		 return employeeDao.getEmployeeById(id);  
	 }
	 
	 @Override
	 @Transactional
	 public void updateEmployee(Employee employee) {  
		 employeeDao.updateEmployee(employee);  
	 }
	 
	 @Override
	 @Transactional
	 public void deleteEmployee(int id) {  
		 employeeDao.deleteEmployee(id);  
	 }		

	@Override
	@Transactional
	public boolean isDuplicatedEmail(String email, int id) {
		return employeeDao.isDuplicatedEmail(email, id);
	}  
	 
}