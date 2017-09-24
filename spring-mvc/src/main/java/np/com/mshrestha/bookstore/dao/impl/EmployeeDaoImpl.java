package np.com.mshrestha.bookstore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import np.com.mshrestha.bookstore.dao.EmployeeDao;
import np.com.mshrestha.bookstore.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;  
	  
	@Override
	public void insertEmployee(Employee employee) {		  
		entityManager.persist(employee);		 
	}
	  
	@Override
	public List<Employee> getList() {		  
		List<Employee> employeeList = entityManager.createQuery("from Employee").getResultList();		  
		return employeeList;  
	}  
	  
	@Override
	public Employee getEmployeeById(int id) {
		entityManager.flush();
		return entityManager.find(Employee.class, id);		
	}  
	  
	@Override
	public void updateEmployee(Employee employee) {		  
		entityManager.merge(employee);
	}  
	  
	@Override
	public void deleteEmployee(int id) {  		 
		Employee employee = getEmployeeById(id);
		if(employee != null)
			entityManager.remove(employee);
	}	

	@Override
	public boolean isDuplicatedEmail(String email, int id) {
		List<Employee> employeeList;
		String req = "from Employee e where e.email = :email";
		if(id != 0){
			req += " and e.id != :id";
			employeeList = entityManager.createQuery(req).setParameter("email", email).setParameter("id", id).getResultList();			
		}
		else
			employeeList = entityManager.createQuery(req).setParameter("email", email).getResultList();
		
		if(employeeList.size() > 0)
			return true;
		return false;
	}	 

}