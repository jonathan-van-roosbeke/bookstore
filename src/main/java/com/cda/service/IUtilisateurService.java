package com.cda.service;

import com.cda.entity.Utilisateur;

public interface IUtilisateurService {

	public Utilisateur connexion(String login, String motdepasse);
	
	public Utilisateur save(Utilisateur utilisateur);
}
