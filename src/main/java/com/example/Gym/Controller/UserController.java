package com.example.Gym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gym.Entity.User;
import com.example.Gym.Service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/validateUser")
	public ResponseEntity<?> validateUser(@RequestParam("userName") String username,
			@RequestParam("password") String password) {
		User user = userService.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return ResponseEntity.ok(user);
		} else if(user==null){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No such user exist");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please check your password & try again.");
		}
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
}
