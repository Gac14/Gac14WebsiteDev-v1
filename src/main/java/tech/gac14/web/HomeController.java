package tech.gac14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tech.gac14.web.bean.Role;
import tech.gac14.web.bean.User;
import tech.gac14.web.dao.DAO;

@Controller
public class HomeController {

	@Autowired
	private DAO dao;
	
	@GetMapping("/")
	public String home(){
		
		return "index.html";
	}
	
	@GetMapping("/about")
	public String about()
	{
		return "about.html";
	}
	@GetMapping("/user")
    public String userIndex() {
        return "user/user-page.html";
    }

    @GetMapping("/login")
    public String login() {
    	
        return "login.html";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied.html";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
    	model.addAttribute("user", new User());
    	return "register.html";
    }
    
    @PostMapping("/newUser")
    public String newUser(@ModelAttribute User user) {
    	user.setRoles(Role.ROLE_USER);
    	user.setEmail("email@email.com");
    	System.out.println(user.toString());
    	dao.addNewUser(user);
    	return "index.html";
    }
    
}
