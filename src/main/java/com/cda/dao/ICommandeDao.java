package com.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cda.entity.Commande;

public interface ICommandeDao extends CrudRepository<Commande, String> {

	@Query("SELECT c FROM Commande c WHERE login = ?1")
	List<Commande> mesCmds(String login);
}
