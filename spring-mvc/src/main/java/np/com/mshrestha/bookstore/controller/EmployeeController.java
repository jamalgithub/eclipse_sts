package np.com.mshrestha.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import np.com.mshrestha.bookstore.model.Employee;
import np.com.mshrestha.bookstore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	 @Autowired  
	 EmployeeService employeeService;
	 
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
		 binder.setAllowedFields(new String[] {"id", "version", "firstName", "lastName", "email", "phone", "gender", "birthday" });
	 }
	 
	 @RequestMapping("/add")  
	 public String addEmployee(Model model) {
		 model.addAttribute("employeeForm", new Employee());
		 return "/employee/form";
	 }  
	 	 
	 @RequestMapping(value ="/save", method = RequestMethod.POST)  
	 public String saveEmployee(@ModelAttribute("employeeForm") @Valid Employee employee, BindingResult result) {  
		 if (result.hasErrors())  //validation error
			 return "/employee/form";
		 else if(employeeService.isDuplicatedEmail(employee.getEmail(), employee.getId())){ //duplicated email error
			 result.rejectValue("email", "ValidEmail.employeeForm.email.duplicated");
			 return "/employee/form";
		 }
		 else{			 			 
			 if (employee.getId() == 0)				 		 
				 employeeService.insertEmployee(employee);			 
			 else			 				 
				 employeeService.updateEmployee(employee);			 
		 }
		 return "redirect:/employee/list";
	 }  
	 
	 @RequestMapping(value = { "", "/", "/list" }) 
	 public String listEmployee(Model model) {  
		  List<Employee> employeeList = employeeService.getList();
		  model.addAttribute("employeeList", employeeList);		  
		  return "/employee/list";
	 }  
	  
	 @RequestMapping("/delete/{employeeId}")  
	 public String deleteEmployee(@PathVariable("employeeId") int id) {  
		  employeeService.deleteEmployee(id);  
		  return "redirect:/employee/list";
	 }  
	  
	 @RequestMapping("/edit/{employeeId}")  
	 public String editEmployee(@PathVariable("employeeId") int id, Model model) {  
		  Employee employee = employeeService.getEmployeeById(id);
		  model.addAttribute("employeeForm", employee);
		  return "/employee/form"; 
	 } 	 	
	
}