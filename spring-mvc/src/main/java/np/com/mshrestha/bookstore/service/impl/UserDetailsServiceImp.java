package np.com.mshrestha.bookstore.service.impl;

import np.com.mshrestha.bookstore.dao.UserDao;
import np.com.mshrestha.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired 
	UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findUserByName(username);   //our own User model class
		if(user == null){
			throw new UsernameNotFoundException("User Not Found" + username);
		}
		else if (user.getRoles().isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " has no authorities");
        }
		else{	//user != null													
			//create spring security user object
			//org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			UserDetailsImp securityUser = new UserDetailsImp(user);
			return securityUser;
		}		
	}
}