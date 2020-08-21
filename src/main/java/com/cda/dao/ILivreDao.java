package com.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cda.entity.Livre;

public interface ILivreDao extends JpaRepository<Livre, Integer> {

	@Override
	List<Livre> findAll();

	Livre findByTitre(String titre);

	List<Livre> findByTitreContainingIgnoreCase(String titre);
}
