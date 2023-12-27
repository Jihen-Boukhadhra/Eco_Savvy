/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;

/**
 *
 * @author tassm
 */
public class Rapport_Recyclage {
    private String Id_Rapport;
    private String Titre;
    private String Contenu;
    private String Auteur;
    public Rapport_Recyclage(String Id_Rapport, String Titre, String Auteur, String Contenu) {
        this.Id_Rapport=Id_Rapport;
        this.Titre=Titre;
        this.Auteur = Auteur;
        this.Contenu = Contenu;}
     public String getId_Rapport(){
        return Id_Rapport;}
     public String getTitre(){
        return Titre;}
    public String getContenu() {
        return Contenu;}
    public String getAuteur() {
        return Auteur;
    }
   //Affichage
    @Override
    public String toString() {
        return "Rapport intitulé :"+ Titre + "de " + Auteur + " : " + Contenu;
    }
}
