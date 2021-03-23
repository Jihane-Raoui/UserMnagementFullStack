package com.users.BackendProj.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.users.BackendProj.models.Utilisateur;
import com.users.BackendProj.services.UserService;

@CrossOrigin(origins="https://usermanagement-react-frontend.herokuapp.com/")
@RestController
@RequestMapping("/api")
public class UserController {
	  @Autowired
	    private UserService service;
	  
	     
	    // list of users...
	    @GetMapping("/user")
	    public List<Utilisateur> viewHomePage() {
	    	return service.listAll();   
	        
	    }
	    //add user
	    @PostMapping("/user")
	    public Utilisateur addUser(@RequestBody Utilisateur user) {
	    	return service.add(user);
	    }
	    //get user by id
	    @GetMapping("/user/{id}")
	    public Utilisateur getbyId(@PathVariable int id) {
	    	Utilisateur user= service.getbyid(id);
			return user;
	    	
	    }
	    //update user
	    @PutMapping("/user/{id}")
	    public Utilisateur update(@ PathVariable int id, @RequestBody Utilisateur userDetails) {
	    	Utilisateur user=service.getbyid(id);
	    	user.setEmail(userDetails.getEmail());
	    	Utilisateur userUpdated=service.saveUser(user);
	    	return userUpdated;
	    }

		// delete employee rest api
		@DeleteMapping("/user/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
			Utilisateur user = service.getbyid(id);
			
			service.deleteUser(user);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
