package com.cda.dao;

import org.springframework.data.repository.CrudRepository;

import com.cda.entity.Commande;

public interface ICommandeDao extends CrudRepository<Commande, Integer> {

}
