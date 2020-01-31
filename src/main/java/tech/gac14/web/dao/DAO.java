package tech.gac14.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import tech.gac14.web.bean.User;

@Repository
public class DAO {

	@Autowired
	protected JdbcTemplate jdbc;
	
	@Autowired
	private DataSource dataSource; 
	
	public User findUser(String username) {
		
		String q = "Select * from user_data WHERE username = ? ";
		User user = (User) this.jdbc.queryForObject(q, new Object[] { username }, 
				new BeanPropertyRowMapper<User>(User.class));
		return user;
		
		
	}
	
	public void addNewUser(User user)
	{
		String q = "INSERT INTO user_data (username,pass,email,roles,age,description) VALUES (?,?,?,?,?,?)";
		Object[] params = new Object[] 
				{
						user.getUsername(),
						encrytePassword(user.getPass()),
						user.getEmail(),
						user.getRoles().name(),	
						user.getAge(),
						user.getDescription()
					
				};
		this.jdbc.update(q,params);
	}


	
	public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
