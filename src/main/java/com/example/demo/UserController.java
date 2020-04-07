package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.user;
import com.example.repository.userRepository;


@Controller
@EntityScan("com.example.domain")
@EnableJpaRepositories("com.example.repository")
public class UserController {

	
	@Autowired
	private userRepository userRepository;
	
	@RequestMapping("/user")
	public ModelAndView getUserList() {
		ModelAndView model = new ModelAndView("user");
		
		model.addObject("list", userRepository.findAll());
		
		return model;
	}
	
	@RequestMapping("/insert")
	public ModelAndView getUserInsert(user user) {
		ModelAndView model = new ModelAndView("user");
		
		userRepository.save(user);
		
		return model;
	}
	
	@RequestMapping("/delete")
	public ModelAndView getUserDelete(user user) {
		ModelAndView model = new ModelAndView("user");
		
		userRepository.deleteById(user.getId());
		
		return model;
	}


	
}
