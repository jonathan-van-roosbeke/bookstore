package com.cda.dao;

import org.springframework.data.repository.CrudRepository;

import com.cda.entity.ArticleCmd;

public interface IArticleCmdDao extends CrudRepository<ArticleCmd, Integer> {
	ArticleCmd findByReferenceLivre(int ref);
}
