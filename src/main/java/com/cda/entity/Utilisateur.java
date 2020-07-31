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
    private String login;
    @Column(name = "nom_utilisateur")
    private String nom;
    @Column(name = "prenom_utilisateur")
    private String prenom;
    @Column(name = "date_connexion_utilisateur")
    private Date dateConnexion;
    @Column(name = "password_utilisateur")
    private String password;
    @Column(name = "active_utilisateur")
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "libelle_role_utilisateur")
    private Roles role;
}

