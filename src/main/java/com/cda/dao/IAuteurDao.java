package com.cda.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cda.entity.Auteur;


public interface IAuteurDao extends CrudRepository<Auteur, Integer> {
	
	@Query("SELECT a FROM Auteur a WHERE nom = ?1 AND prenom = ?2")
	Auteur findByNomPrenom(String nom, String prenom);
	
}
