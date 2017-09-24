package com.springinpractice.ch04.dao;

import com.springinpractice.ch04.domain.Account;
import com.springinpractice.dao.Dao;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface AccountDao extends Dao<Account> {
	
	void create(Account account, String password);
	
	Account findByUsername(String username);
}