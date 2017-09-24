package com.springinpractice.ch04.dao;

import com.springinpractice.ch04.domain.Role;
import com.springinpractice.dao.Dao;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface RoleDao extends Dao<Role> {
	
	Role findByName(String name);
}