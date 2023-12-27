/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author tassm
 */
public final class Verre extends Dechet {
    private String color;
    private int Transparency_Level;// 0-100 scale for transparency
    private Date Production_Date;

    public Verre(String color, int Transparency_Level, Date Production_Date, String wasteId, boolean isRecyclable, boolean isBiodegradable, double quantityStock, double weight, double lifespan) throws InvalidQuantityException {
        super(wasteId, isRecyclable, isBiodegradable, quantityStock, weight, lifespan);

        if (quantityStock < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative.");
        }
        
        this.color = color;
        this.Transparency_Level = Transparency_Level;
        this.Production_Date = Production_Date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransparency_Level() {
        return Transparency_Level;
    }

    public void setTransparency_Level(int Transparency_Level) {
        this.Transparency_Level = Transparency_Level;
    }

    public Date getProduction_Date() {
        return Production_Date;
    }

    public void setProduction_Date(Date Production_Date) {
        this.Production_Date = Production_Date;
    }

    @Override
    public String toString() {
        
        return (super.toString()+";"+"Verre" + ";" + color + ";" + Transparency_Level + ";" + Production_Date );
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
