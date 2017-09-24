package np.com.mshrestha.bookstore.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import np.com.mshrestha.bookstore.service.validation.ValidEmail;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
@NamedQuery(name = "findEmployeeByEmail", query = "select e from Employee e where e.email = :email")
public class Employee {

	 @Id  
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;  
	 
	 @Version
	 private int version;
	 
	 @NotEmpty
	 @Column(name = "first_name")
	 private String firstName;  
	 
	 @NotNull
	 @Column(name = "last_name")
	 private String lastName = null;
	 	
	 @ValidEmail
	 //@Email
	 @Size(min=5, max=20)
	 private String email;
	 
	 @Size(min=10, max=10)
	 private String phone;  
	 
	 @NotEmpty
	 private String gender;
	 
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 @NotNull
	 @Temporal(value = TemporalType.DATE)
	 private Date birthday;	 
	 
	/* @DateTimeFormat(pattern="dd/MM/yyyy")
	 @NotNull
	 @Temporal(value = TemporalType.DATE)
	 @Column(name = "last_update")
	 private Date lastUpdate;*/
	 
	 /*@ManyToMany
	 @JoinTable(
		name = "account_role",
		joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
	 )
	 private Collection<Role> roles = new HashSet<Role>();*/
	 
	 public int getId() { 
		 return id;  
	 }  
	  
	 public void setId(int id) {  
		 this.id = id;  
	 }  
	  
	 public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFirstName() {  
		 return firstName;  
	 }  
	  
	 public void setFirstName(String firstName) {  
		 this.firstName = firstName;  
	 }  
	  
	 public String getLastName() {  
		 return lastName;  
	 }  
	  
	 public void setLastName(String lastName) {  
		 this.lastName = lastName;  
	 }  
	  
	 public String getEmail() {  
		 return email;  
	 }  
	  
	 public void setEmail(String email) {  
		 this.email = email;  
	 }  
	  
	 public String getPhone() {  
		 return phone;  
	 }  
	  
	 public void setPhone(String phone) {  
		 this.phone = phone;  
	 }

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}	
	
}