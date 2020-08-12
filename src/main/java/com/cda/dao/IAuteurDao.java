package com.cda.dao;

import org.springframework.data.repository.CrudRepository;

import com.cda.entity.Auteur;

public interface IAuteurDao extends CrudRepository<Auteur, Integer> {

}
