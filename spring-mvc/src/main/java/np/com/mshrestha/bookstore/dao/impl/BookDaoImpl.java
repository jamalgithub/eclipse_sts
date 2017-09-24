package np.com.mshrestha.bookstore.dao.impl;

import java.util.List;

import np.com.mshrestha.bookstore.dao.BookDao;
import np.com.mshrestha.bookstore.model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * saving a new book or updating an existing book
	 */
	public void saveBook(Book book) {
		getSession().merge(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> listBooks() {
		return getSession().createCriteria(Book.class).list();
	}

	public Book getBook(Long id) {
		return (Book) getSession().get(Book.class, id);
	}

	public void deleteBook(Long id) {
		Book book = getBook(id);
		if (null != book) {
			getSession().delete(book);
		}
	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}