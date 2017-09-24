package np.com.mshrestha.bookstore.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import np.com.mshrestha.bookstore.model.Role;
import np.com.mshrestha.bookstore.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImp implements UserDetails{
	private User user;

	public UserDetailsImp(User user) {
		this.user = user;
	}
	
	public User getAccount() {
		return user;
	}
    public int getId() {
    	return user.getId();
    }
    public String getFirstName() {
    	return user.getFirstName();
    }     
    public String getLastName() {
    	return user.getLastName();
    }
    public String getFullName() {
    	return user.getFullName();
    }
    public String getEmail() {
    	return user.getEmail();
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for(Role role:user.getRoles()){
			authorities.add(new GrantedAuthorityImpl(role.getRolename()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
}
