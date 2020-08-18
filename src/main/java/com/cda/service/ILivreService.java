package com.cda.service;

import java.util.List;

import com.cda.dto.LivreDto;
import com.cda.entity.Livre;

public interface ILivreService {

	List<LivreDto> findAll();

	Livre findById(Integer id);
	
	Livre save(Livre livre);
	
	void deleteById(Integer id);

}
