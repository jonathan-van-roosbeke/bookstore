package com.cda.dao;

import org.springframework.data.repository.CrudRepository;

import com.cda.entity.Utilisateur;

public interface IUtilisateurDao extends CrudRepository<Utilisateur, Integer> {
	
	public Utilisateur connexion(String login, String password);
	
}
