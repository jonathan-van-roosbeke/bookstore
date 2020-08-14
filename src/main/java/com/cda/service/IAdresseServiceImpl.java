package com.cda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.dao.IAdresseDao;
import com.cda.entity.Adresse;
@Service
public class IAdresseServiceImpl implements IAdresseService {

	@Autowired
	IAdresseDao adresseDao;
	
	@Override
	public Adresse save(Adresse adresse) {
		return adresseDao.save(adresse);
	}
}
