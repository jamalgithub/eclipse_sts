package com.springinpractice.ch04.dao.hbn;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springinpractice.ch04.dao.AccountDao;
import com.springinpractice.ch04.domain.Account;
import com.springinpractice.dao.hibernate.AbstractHbnDao;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Repository
public class HbnAccountDao extends AbstractHbnDao<Account> implements AccountDao {
	private static final Logger LOG = LoggerFactory.getLogger(HbnAccountDao.class);
	
	private static final String UPDATE_PASSWORD_SQL = "update Account set password = :password where username = :username";
		
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Account account, String password) {
		LOG.debug("Creating Account");
		create(account);
		
		/*LOG.debug("Updating password");
		
		SQLQuery query = getSession().createSQLQuery(UPDATE_PASSWORD_SQL);
		query.setParameter("password", password);
		query.setParameter("username", account.getUsername());
		query.uniqueResult();*/
	}

	@Override
	public Account findByUsername(String username) {
		Query q = getSession().getNamedQuery("findAccountByUsername");
		q.setParameter("username", username);
		return (Account) q.uniqueResult();
	}
	
	@Override
	public Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
}