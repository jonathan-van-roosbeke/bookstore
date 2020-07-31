package com.cda.dao;

import java.util.Optional;
import com.cda.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;


public interface IUtilisateurDao extends CrudRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByLoginAndPassword(String pLogin, String pPassword);
}
