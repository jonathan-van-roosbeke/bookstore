package com.cda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cda.dao.ILivreDao;

public class LivreServiceImpl implements ILivreService {

	@Autowired
	private ILivreDao livreDao;
}
