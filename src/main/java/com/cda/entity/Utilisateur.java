package com.cda.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    @Column(name = "login_utilisateur")
    private String loginUtilisateur;
    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;
    @Column(name = "prenom_utilisateur")
    private String prenomUtilisateur;
    @Column(name = "date_connexion_utilisateur")
    private Date dateConnexionUtilisateur;
    @Column(name = "password_utilisateur")
    private String passwordUtilisateur;
    @Column(name = "active_utilisateur")
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "libelle_role_utilisateur")
    private Roles role;
}

