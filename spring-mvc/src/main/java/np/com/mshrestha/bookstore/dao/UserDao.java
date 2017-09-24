package np.com.mshrestha.bookstore.dao;

import java.util.List;

import np.com.mshrestha.bookstore.model.User;

public interface UserDao {
	void addUser(User user);
	void editUser(User user);
	void deleteUser(int userId);
	User findUser(int userId);
	User findUserByName(String username);
	List<User> getAllUsers();
}
