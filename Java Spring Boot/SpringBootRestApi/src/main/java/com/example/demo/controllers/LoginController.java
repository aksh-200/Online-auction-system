package com.example.demo.controllers;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Forget;
import com.example.demo.entities.LoginCheck;
import com.example.demo.entities.PassBasedEnc;
import com.example.demo.entities.Reset;
import com.example.demo.entities.SaltValue;
import com.example.demo.entities.User;
import com.example.demo.services.QuestionService;
import com.example.demo.services.UserService;

@CrossOrigin(origins = {"http://localhost:3000" ,"https://react-auction-app-8080-tb6e.vercel.app"})

@RestController
public class LoginController {
	@Autowired
	UserService userv;
	@Autowired
	QuestionService qserv;
	
	@Autowired
	SaltValue saltValue;
	
	@PostMapping("/checklogin")
	public User checkLogin(@RequestBody LoginCheck lcheck)
	{
		String encrypted=PassBasedEnc.generateSecurePassword(lcheck.getPassword(),saltValue.getSalt());
		System.out.println(encrypted);
		
		return userv.getUser(lcheck.getUsername(), encrypted);
	}
	
	@GetMapping("/getAll")
	public List<User> getAll()
	{
		return userv.getAll();
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam("user_id") int user_id)
	{
		return userv.getById(user_id);
	}
	
	@PostMapping("/forget")
	public  User checkUser(@RequestBody Forget f)
	{
		//Question q_id = qserv.getQuestion(f.getQ_id());
		//System.out.println(q_id.getQuestion()+ );
		
		//User u=new User(q_id,f.getUsername(),f.getAnswer());
		System.out.println(f.getQ_id()+ " " +f.getUsername() + " " +f.getAnswer());
		return userv.check(f.getUsername(),f.getAnswer(),Integer.parseInt(f.getQ_id()));
	}
	
	@PostMapping("/reset1")
	public boolean reset(@RequestBody Reset r)
	{
		//return userv.savePass(r.getUsername(),r.getPassword());
		boolean flag = true;
		try {
			
			String encrypted=PassBasedEnc.generateSecurePassword(r.getPassword(),saltValue.getSalt());
			System.out.println(encrypted);
			flag = userv.savePass(r.getUsername(),encrypted);
		}
		catch(Exception e)
		{
			flag=false;
		}
		return flag;
	} 

}
