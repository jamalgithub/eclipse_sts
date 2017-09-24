package com.springinpractice.ch04.service;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.springinpractice.ch04.dao.AccountDao;
import com.springinpractice.ch04.dao.RoleDao;
import com.springinpractice.ch04.domain.Account;
import com.springinpractice.ch04.domain.Role;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Inject 
	private AccountDao accountDao;
	@Inject 
	private RoleDao roleDao;
	
	@Override
	@Transactional(readOnly = false)	
	public boolean registerAccount(Account account, String password, Errors errors) {
		validateUsername(account.getUsername(), errors);
		boolean valid = !errors.hasErrors();
		
		if (valid) {
			Set<Role> roles = new HashSet<Role>();
			roles.add(roleDao.findByName("user"));
			account.setRoles(roles);
			accountDao.create(account, password);
		}
		
		return valid;
	}
	
	private void validateUsername(String username, Errors errors) {
		if (accountDao.findByUsername(username) != null) {
			log.debug("Validation failed: duplicate username");
			errors.rejectValue("username", "error.duplicate", new String[] { username }, null);
		}
	}
}