package com.cda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cda.dao.IUtilisateurDao;
import com.cda.entity.Utilisateur;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private IUtilisateurDao utilisateurDao;

	@Override
	public Utilisateur connexion(String login, String motdepasse) {
		Utilisateur utilisateur = utilisateurDao.connexion(login, motdepasse);
		System.out.println(utilisateur);
		return utilisateur;
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurDao.save(utilisateur);
	}

	@Override
	public List<Utilisateur> findCompteEnAttente() {
		return utilisateurDao.findCompteEnAttente();
	}

	@Override
	public Utilisateur findById(String login) {
		Optional<Utilisateur> utilisateurOp = utilisateurDao.findById(login);
		if (utilisateurOp.isPresent()) {
			return utilisateurOp.get();
		}
		return null;
	}

	@Override
	public void deleteById(String id) {
		utilisateurDao.deleteById(id);

	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurDao.findAll();
	}

	@Override
	public Page<Utilisateur> getPage(int pageNo, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
		return utilisateurDao.findAll(pageable);
	}

	@Override
	public Page<Utilisateur> getPage(int pageNo, int pageSize, List list) {
		PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);

		int start = (int) pageable.getOffset();
		int end = (start + pageable.getPageSize()) > list.size() ? list.size() : (start + pageable.getPageSize());
		Page<Utilisateur> page = new PageImpl<Utilisateur>(list.subList(start, end), pageable, list.size());

		return page;
	}
}