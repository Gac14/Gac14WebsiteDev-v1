package ca.Gac14;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import ca.Gac14.dao.DAO;

@Service
public class UserDetailedSeviceImpl implements UserDetailsService {
	
	@Autowired
	private DAO dao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ca.Gac14.bean.User user = dao.findUser(username);
	       
        if (user == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
 
        
 
       
        ArrayList<String> roleNames = new ArrayList<String>();
        roleNames.add("ROLE_USER");
        		
        		
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
               
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(user.getUsername(), //
                user.getPass(), grantList);
 
        return userDetails;	
	}

}
