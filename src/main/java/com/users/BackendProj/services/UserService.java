package com.users.BackendProj.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.users.BackendProj.models.Utilisateur;
import com.users.BackendProj.repository.UserRepository;



@Service
@Transactional
public class UserService {
	 @Autowired
	    private UserRepository repo;
	   
	    public List<Utilisateur> listAll() {
	        return repo.findAll();
	    }
	    
	    public Utilisateur add(Utilisateur user) {
	    	return repo.save(user);
	    }

		public Utilisateur getbyid(int id) {
			
			return repo.findById(id);
		}

		public Utilisateur saveUser(Utilisateur user) {
			
			return repo.save(user);
		}

		public void deleteUser(Utilisateur user) {
			 
			repo.delete(user);
			
		}
}
