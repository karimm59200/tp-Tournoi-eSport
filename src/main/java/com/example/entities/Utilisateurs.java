package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private int id;
    private String utilisateur;

    private String motDePasse;

    private boolean roleAdmin = false;

}
