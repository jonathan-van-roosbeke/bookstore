package com.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cda.entity.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, String> {

	@Query("SELECT u FROM Utilisateur u WHERE login = ?1 AND motdepasse = md5(?2)")
	Utilisateur connexion(String login, String motdepasse);

	@Query("SELECT u FROM Utilisateur u WHERE status_utilisateur = 0")
	List<Utilisateur> findCompteEnAttente();

}
