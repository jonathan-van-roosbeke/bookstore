package com.cda.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "t_article_cmd")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCmd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_article")
	private int id;

	@Column(name = "titre")
	private String titre;

	@Column(name = "quantite")
	private int quantite;

	@Column(name = "prix")
	private double prix;

	@Column(name = "total_prix")
	private double totalPrix;

	@ManyToOne(targetEntity = Commande.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "numero_cmd", referencedColumnName = "numero_cmd", nullable = false, insertable = false, updatable = false)
	private Commande commande;

	private String numero_cmd;

	@OneToOne(targetEntity = Livre.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "reference_livre", referencedColumnName = "reference_livre", nullable = false, insertable = false, updatable = false)
	private Livre livre;

	private int reference_livre;
}
