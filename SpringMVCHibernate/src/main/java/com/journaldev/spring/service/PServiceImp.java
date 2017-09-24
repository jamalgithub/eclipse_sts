package com.journaldev.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PDao;
import com.journaldev.spring.model.Person;

@Service("personService")
public class PServiceImp implements PersonService {

	@Inject
	private PDao personDAO;

	public void setPersonDAO(PDao personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.create(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.update(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.getAll();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.get(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.delete(getPersonById(id));
	}
}
