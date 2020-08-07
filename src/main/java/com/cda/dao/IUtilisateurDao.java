package com.cda.dao;

import org.springframework.data.repository.CrudRepository;

import com.cda.entity.Utilisateur;

public interface IUtilisateurDao extends CrudRepository<Utilisateur, Integer> {
//    Optional<Utilisateur> findByLoginAndPassword(String pLogin, String pPassword);
}
