package com.cda.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cda.entity.Livre;

public interface ILivreDao extends CrudRepository<Livre, Integer> {
	
	List<Livre> findAll();
}
