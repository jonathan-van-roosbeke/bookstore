package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_livre")
    Integer referenceLivre;
    @Column(name = "titre_livre")
    String titreLivre;
    @Column(name = "quantite_stock")
    int quantiteStock;
    @Column(name = "nombre_page")
    int nombrePage;
    @Column(name = "synopsis")
    String synopsis;
    @Column(name = "nom_image")
    String nomImage;
    @Column(name = "prix_livre")
    float prixLivre;
}
