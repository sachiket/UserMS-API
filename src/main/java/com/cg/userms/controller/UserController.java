package com.cg.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cg.userms.entity.Userdata;
import com.cg.userms.repository.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app")
public class UserController {

	@Autowired
	UserRepository repo;
	
	@GetMapping("/test")
	public String test() {
		return "its working";
	}
	
	@GetMapping("/getuser")
	public Userdata getUser(@RequestParam int userId) {
		return repo.findById(userId).get();
	}
	
	@GetMapping("/getalluser")
	public List<Userdata> getAllUsers() {
		return (List<Userdata>) repo.findAll();
	}
	
	@DeleteMapping("/deleteuser")
	public boolean deleteUser(@RequestParam int userId) {
		repo.deleteById(userId);
		return true;
	}
	
	@PostMapping("/adduser")
	public boolean adduser(@RequestBody Userdata user) {
		repo.save(user);
		return true;
	}
	
	
}
