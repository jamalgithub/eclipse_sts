package com.springinpractice.ch05.form;

import java.io.Serializable;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.springinpractice.ch05.domain.Guardian;
import com.springinpractice.ch05.domain.Player;

/**
 * @author Joshua White
 */
public class AccountForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Valid
	protected Guardian guardian = new Guardian();
	
	@Valid
	protected Player child = new Player();
	
	@NotEmpty
	protected String confirmPassword;
	
	@NotEmpty
	@Email
	protected String confirmEmail;
	
	public AccountForm() {}
	
	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}
	
	public Player getChild() {
		return child;
	}

	public void setChild(Player child) {
		this.child = child;
	}
		
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	
}