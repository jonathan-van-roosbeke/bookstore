package com.cda.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cda.entity.Livre;

public interface ILivreService {

	List<Livre> findAll();

	Livre findById(Integer id);

	Livre save(Livre livre);

	void deleteById(Integer id);

	Page<Livre> getPage(int pageNo, int pageSize);

}
