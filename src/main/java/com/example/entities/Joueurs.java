package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joueurs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nomUtilisateur;

    private String jeuSpecialite;

    @ManyToOne
    @JoinColumn(name="equipe_id")
    private Equipe equipe;

    public Joueurs(String nomUtilisateur, String jeuSpecialite) {
        this.nomUtilisateur = nomUtilisateur;
        this.jeuSpecialite = jeuSpecialite;

    }
}
