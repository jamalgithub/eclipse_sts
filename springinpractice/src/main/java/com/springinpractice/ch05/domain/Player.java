package com.springinpractice.ch05.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Joshua White
 */
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Guardian guardian;
	
	@NotEmpty
	protected String firstName;
	
	@NotEmpty
	protected String lastName;
	
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	protected Date birthDate;	
			
	public Player() {}
		
	public Player(Guardian guardian, String firstName, String lastName, Date birthDate) {
		this.guardian = guardian;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("firstName", firstName)
		.append("lastName", lastName)
		.append("birthDate", birthDate)		
		.toString();		
	}
	
}