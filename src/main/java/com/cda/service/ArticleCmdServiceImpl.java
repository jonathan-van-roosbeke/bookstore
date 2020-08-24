package com.cda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.dao.IArticleCmdDao;
import com.cda.entity.ArticleCmd;

@Service
public class ArticleCmdServiceImpl implements IArticleCmdService {

	@Autowired
	IArticleCmdDao articleCmdDao;

	@Override
	public List<ArticleCmd> getArticleCmd(String numeroCmd) {
		int numero = Integer.parseInt(numeroCmd);
		articleCmdDao.findById(numero);
		return null;
	}

	@Override
	public void saveArticle(List<ArticleCmd> articleCmd) {
		articleCmdDao.saveAll(articleCmd);
	}

	@Override
	public ArticleCmd findByReferenceLivre(int ref) {
		return articleCmdDao.findByReferenceLivre(ref);
	}

}
