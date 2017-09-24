package com.journaldev.spring.dao;

import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;

@Repository("personDAO")
public class PDaoImp extends AbstractHbnDao<Person> implements PDao {
	
}
