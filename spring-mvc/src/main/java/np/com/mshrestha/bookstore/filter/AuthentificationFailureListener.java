package np.com.mshrestha.bookstore.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import np.com.mshrestha.bookstore.dao.UserDao;
import np.com.mshrestha.bookstore.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthentificationFailureListener implements AuthenticationFailureHandler {
	@Autowired 
	UserDao userDao;
	
	private static final int MAX_ATTEMPTS = 3;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,	HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		UsernamePasswordAuthenticationToken user =(UsernamePasswordAuthenticationToken)exception.getAuthentication();
		
		User u = userDao.findUserByName((String) user.getPrincipal());
		if(u != null){
			if(u.isAccountNonLocked()){
				if(u.getAttempts() + 1 < MAX_ATTEMPTS){
					u.setAttempts(u.getAttempts()+1);
					userDao.editUser(u);
					response.sendRedirect("login?failed=error1");
					return ;
				}
				else if(u.getAttempts() + 1 == MAX_ATTEMPTS){
					u.setAccountNonLocked(false);
					userDao.editUser(u);
					response.sendRedirect("login?failed=error2");
					return ;
				}			
			}
			else {
				response.sendRedirect("login?failed=error2");
				return ;
			}
		}
		else{
			response.sendRedirect("login?failed=error");
			return ;
		}
		
		response.sendRedirect("login?failed=error");
		return ;
	}

}
