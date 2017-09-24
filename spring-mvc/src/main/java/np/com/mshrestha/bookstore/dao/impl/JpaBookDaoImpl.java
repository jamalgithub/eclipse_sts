package np.com.mshrestha.bookstore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import np.com.mshrestha.bookstore.dao.BookDao;
import np.com.mshrestha.bookstore.model.Book;

@Repository("jpabookDao")
public class JpaBookDaoImpl implements BookDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void saveBook(Book book) {
		entityManager.merge(book);
	}

	@Override
	public List<Book> listBooks() {
		Query query = entityManager.createQuery("from Book");
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public Book getBook(Long id) {		
		return entityManager.find(Book.class, id);
	}

	@Override
	public void deleteBook(Long id) {
		Book book = getBook(id);
		if (null != book) {
			entityManager.remove(book);
		}
	}
	
}
