package com.cda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_commande")
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "numero_cmd")
	private String numeroCmd;

	@Column(name = "date_creation")
	private LocalDateTime date;

	@Column(name = "status_cmd")
	private int status;

	@Column(name = "total_cmd")
	private double totalCmd;

	@ManyToOne(targetEntity = Utilisateur.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "login", referencedColumnName = "login", nullable = false, insertable = false, updatable = false)
	private Utilisateur utilisateur;

	private String login;
}
