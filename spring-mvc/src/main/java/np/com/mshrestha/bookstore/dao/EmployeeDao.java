package np.com.mshrestha.bookstore.dao;

import java.util.List;

import np.com.mshrestha.bookstore.model.Employee;

public interface EmployeeDao {
	 public void insertEmployee(Employee employee);  	  
	 public List<Employee> getList();  	  
	 public Employee getEmployeeById(int id);	 
	 public boolean isDuplicatedEmail(String email, int id);	  
	 public void updateEmployee(Employee employee);  	  
	 public void deleteEmployee(int id); 	 	
}