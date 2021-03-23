package com.users.BackendProj.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table
public class Utilisateur {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int idU; 
	 
	 @Column(nullable = false)
	 private String nom;
	 @Column(nullable = false)
	 private String prenom;
	 
	 @Column(nullable = false, unique = true)
	private String email;
	 
	 @Column
	private String mdp;
	 
}
