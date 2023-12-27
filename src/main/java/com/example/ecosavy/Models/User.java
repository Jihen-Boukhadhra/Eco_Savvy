/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;


import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tassm
 */

public abstract class User   {




    protected String Nom_user;
    protected String Email_user;
    protected Secteur Secteur;
    //type énuméré
    public  enum Secteur{
        industriel,
        commercial,
        culturel,
        sportif
    }
    // Constructeur
    public User( String Nom_user, String Email_user, Secteur Secteur) {

        this.Nom_user = Nom_user;
        this.Email_user = Email_user;
        this.Secteur=Secteur; 
    }
    // Getters et Setters

    public String getNom_user() {
        return Nom_user;
    }

    public void setNom_user(String nom_user) {
        Nom_user = nom_user;
    }

    public String getEmail_user() {
        return Email_user;
    }

    public void setEmail_user(String email_user) {
        Email_user = email_user;
    }

    public User.Secteur getSecteur() {
        return Secteur;
    }

    public void setSecteur(User.Secteur secteur) {
        Secteur = secteur;
    }




    /* public void consulterAnnonce(Annonce annonce) {
        System.out.println("Consultation de l'annonce : " + annonce.getTitre());
        System.out.println("Description : " + annonce.getDescription());
}*/
}
