package com.cda.service;

import com.cda.entity.Auteur;

public interface IAuteurService {
	
	Auteur save(Auteur auteur);
	
	Auteur findByNomPrenom(String nom, String prenom);
}
