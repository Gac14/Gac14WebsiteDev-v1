package ca.Gac14.bean;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	public String username;
	public String pass;
	public String email;
	public Role roles;
	public int age;
	public String description;
}
