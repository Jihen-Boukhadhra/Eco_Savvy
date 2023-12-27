/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;

public  class Commentaire {
        String ID_Comment;
        String Libelle;
        String Auteur;
        String Contenu;

    public Commentaire(String ID_Comment, String libelle, String auteur, String contenu) {
        this.ID_Comment = ID_Comment;
        Libelle = libelle;
        Auteur = auteur;
        Contenu = contenu;
    }

    public String getID_Comment() {
        return ID_Comment;
    }

    public void setID_Comment(String ID_Comment) {
        this.ID_Comment = ID_Comment;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "ID_Comment='" + ID_Comment + '\'' +
                ", Libelle='" + Libelle + '\'' +
                ", Auteur='" + Auteur + '\'' +
                ", Contenu='" + Contenu + '\'' +
                '}';
    }
}