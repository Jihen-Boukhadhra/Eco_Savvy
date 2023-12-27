/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;

/**
 *
 * @author tassm
 */
public  class Provider extends User {
    private String Nom_entreprise;
    // Constructeur
    public Provider(String nom_user, String email_user, Secteur Secteur, String entreprise) {
        super( nom_user, email_user, Secteur);
        this.Nom_entreprise = entreprise;
    }
    // Getters et Setters
    public String getEntreprise() {
        return Nom_entreprise;
    }
    public void setEntreprise(String entreprise) {
        this.Nom_entreprise = entreprise;
    }
   //Affichage
    @Override
    public String toString() {
        return (Nom_user +
                ";" + Email_user +
                ";" + Secteur +
                ";" + Nom_entreprise);
    }
    
}
