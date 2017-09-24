package np.com.mshrestha.bookstore.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import np.com.mshrestha.bookstore.dao.UserDao;
import np.com.mshrestha.bookstore.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthentificationSuccessListener implements	AuthenticationSuccessHandler {
	@Autowired 
	UserDao userDao;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,	HttpServletResponse response, Authentication authentication) throws IOException, ServletException {		
		UsernamePasswordAuthenticationToken user= (UsernamePasswordAuthenticationToken) authentication;
		User u = userDao.findUserByName(user.getName());
		if(u.getAttempts() != 0){
			u.setAttempts(0);
			userDao.editUser(u);
		}
			
		response.sendRedirect("employee");
	}

}
