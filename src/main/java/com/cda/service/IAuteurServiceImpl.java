package com.cda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.dao.IAuteurDao;
import com.cda.entity.Auteur;

@Service
public class IAuteurServiceImpl implements IAuteurService {

	@Autowired
	IAuteurDao auteurDao;

	@Override
	public Auteur save(Auteur auteur) {
		return auteurDao.save(auteur);
	}

}
