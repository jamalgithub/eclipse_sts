package com.jamal.jsf.dataTable;

import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DataTableBean {
	private String name;
	private String dept;
	private int age;
	private double salary;
	private boolean canSave;
	private boolean canAdd;
	private Employee employee;
	private static final ArrayList<Employee> employees = new ArrayList<Employee>(Arrays.asList(
	    new Employee("John", "Marketing", 30,2000.00),
	    new Employee("Robert", "Marketing", 35,3000.00),
	    new Employee("Mark", "Sales", 25,2500.00),
	    new Employee("Chris", "Marketing", 33,2500.00),
	    new Employee("Peter", "Customer Care", 20,1500.00)
	));
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	private void resset(){
		name = null;
		dept = null;
		age = 0;
		salary = 0.0;
	}
	
	public String add() {
		canAdd = true;
		return null;
	}
	
	public String addEmployee() {		 
		Employee employee = new Employee(name,dept,age,salary);
		employees.add(employee);
		canAdd = false;
		resset();
		return null;
	}

	/*public String deleteEmployee(Employee employee) {
		employees.remove(employee);		
		return null;
	}*/
	
	public String deleteEmployee() {
		employees.remove(employee);		
		return null;
	}

	public String editEmployee(Employee employee){
		employee.setCanEdit(true);
		canSave = true;
		return null;
	}

	public String saveEmployees(){
		for (Employee employee : employees){
			employee.setCanEdit(false);
		}	
		canSave = false;
		return null;
	}
	   
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isCanSave() {
		return canSave;
	}

	public void setCanSave(boolean canSave) {
		this.canSave = canSave;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isCanAdd() {
		return canAdd;
	}

	public void setCanAdd(boolean canAdd) {
		this.canAdd = canAdd;
	}
}
