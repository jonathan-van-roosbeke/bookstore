package com.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cda.entity.ArticleCmd;
import com.cda.entity.Commande;

public interface ICommandeDao extends JpaRepository<Commande, String> {

	@Query("SELECT c FROM Commande c WHERE login = ?1")
	List<Commande> mesCmds(String login);

	@Query("SELECT a FROM ArticleCmd a WHERE numero_cmd = ?1")
	List<ArticleCmd> detailCmd(String numeroCmd);

	@Query(nativeQuery = true, value = "select * from t_commande c where c.login=:login limit :offset, :size")
	List<Commande> mesCmds(@Param("login") String login, @Param("offset") int offset, @Param("size") int size);

}
