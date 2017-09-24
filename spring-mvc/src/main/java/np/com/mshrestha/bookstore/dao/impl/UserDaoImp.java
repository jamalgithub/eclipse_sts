package np.com.mshrestha.bookstore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import np.com.mshrestha.bookstore.dao.UserDao;
import np.com.mshrestha.bookstore.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImp implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	//@Autowired
	//private SessionFactory sessionFactory;		
	
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
		//sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void editUser(User user) {
		entityManager.merge(user);
		//sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(int userId) {
		entityManager.remove(findUser(userId));
		//sessionFactory.getCurrentSession().delete(findUser(userId));
	}

	@Override
	public User findUser(int userId) {
		entityManager.flush();
		return entityManager.find(User.class, userId);
		//return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public User findUserByName(String username) {
		Query q = entityManager.createQuery("from User u where u.username = :username");
		q.setParameter("username", username);
		User u;
		try {
			u = (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
//		criteria.add(Restrictions.eq("username", username));
//		User u = (User) criteria.uniqueResult();
		
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		return entityManager.createQuery("from User").getResultList();
		//return sessionFactory.getCurrentSession().createQuery("from User").list();
	}	

}