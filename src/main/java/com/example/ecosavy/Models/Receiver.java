/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tassm
 */
public final class  Receiver extends User {

    private String Nom_entreprise;
    private String Password;
    // Cpackageonstructeur

    public Receiver( String nom_user, String email_user, Secteur Secteur, String Nom_entreprise,String Password) {
        super( nom_user, email_user, Secteur);
        this.Nom_entreprise = Nom_entreprise;
        this.Password=Password;
    }

    //Affichage

    @Override
    public String toString() {
        return (Nom_user +
                ";" + Email_user +
                ";" + Password +
                ";" + Secteur +
                ";" + Nom_entreprise);

    }

    public String getNom_entreprise() {
        return Nom_entreprise;
    }

    public String getPassword() {
        return Password;
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the user data to the file
            writer.write(toString());
            writer.newLine();
            // You may want to add error handling in a real-world application
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    }

    

