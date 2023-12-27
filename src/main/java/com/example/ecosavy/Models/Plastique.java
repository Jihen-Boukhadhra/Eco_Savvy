/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tassm
 */
public final class Plastique extends Dechet {
    private String typePlastic;
    private int codePlastic;

    public Plastique(String typePlastic, int codePlastic, String wasteId, boolean isRecyclable, boolean isBiodegradable, double quantityStock, double weight, double lifespan) throws InvalidQuantityException {
        super(wasteId, isRecyclable, isBiodegradable, quantityStock, weight, lifespan);
        if (quantityStock < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative.");
        }
        
        
        this.typePlastic = typePlastic;
        this.codePlastic = codePlastic;
    }

    public String getTypePlastic() {
        return typePlastic;
    }

    public void setTypePlastic(String typePlastic) {
        this.typePlastic = typePlastic;
    }

    public int getCodePlastic() {
        return codePlastic;
    }

    public void setCodePlastic(int codePlastic) {
        this.codePlastic = codePlastic;
    }

    @Override
    public String toString() {
        super.toString();
        return (super.toString()+";"+"Plastique"+";"+ typePlastic + ";" + codePlastic );
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
