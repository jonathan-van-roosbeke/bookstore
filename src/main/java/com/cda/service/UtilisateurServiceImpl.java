package com.cda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.dao.IUtilisateurDao;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private IUtilisateurDao utilisateurDao;

	@Override
	public boolean exists(String login, String password) {
//        return this.utilisateurDao.findByLoginAndPassword(login, password).isPresent();
		return false;
	}
}