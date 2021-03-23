package com.users.BackendProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.BackendProj.models.Utilisateur;


public interface UserRepository  extends JpaRepository<Utilisateur, Integer> {
	Utilisateur findById(int id);
}
