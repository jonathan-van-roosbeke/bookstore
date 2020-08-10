package com.cda.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cda.entity.Utilisateur;

public interface IUtilisateurDao extends CrudRepository<Utilisateur, String> {

	@Query("SELECT a FROM Utilisateur a WHERE login = ?1 AND motdepasse = md5(?2)")
	Utilisateur connexion(String login, String motdepasse);

}
