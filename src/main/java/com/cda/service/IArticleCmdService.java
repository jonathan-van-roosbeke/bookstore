package com.cda.service;

import java.util.List;

import com.cda.entity.ArticleCmd;

public interface IArticleCmdService {

	void saveArticle(List<ArticleCmd> articleCmd);

	List<ArticleCmd> getArticleCmd(String numeroCmd);

}
