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
public final class Electronic extends Dechet{
    public enum Status{
        functional,
        damaged,
        obsolete,
    };
    private int voltage;
    private Status Usability_Status;
    private String E_waste_Category;// can be computers, batteries...
    private boolean containsRareMaterials;
    private Date manufacturingDate;

    public Electronic(int voltage, Status Usability_Status, String E_waste_Category, boolean containsRareMaterials, Date manufacturingDate, String wasteId, boolean isRecyclable, boolean isBiodegradable, double quantityStock, double weight, double lifespan) throws InvalidQuantityException {
        super(wasteId, isRecyclable, isBiodegradable, quantityStock, weight, lifespan);
        if (quantityStock < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative.");
        }
        
        this.voltage = voltage;
        this.Usability_Status = Usability_Status;
        this.E_waste_Category = E_waste_Category;
        this.containsRareMaterials = containsRareMaterials;
        this.manufacturingDate = manufacturingDate;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public Status getUsability_Status() {
        return Usability_Status;
    }

    public void setUsability_Status(Status Usability_Status) {
        this.Usability_Status = Usability_Status;
    }

    public String getE_waste_Category() {
        return E_waste_Category;
    }

    public void setE_waste_Category(String E_waste_Category) {
        this.E_waste_Category = E_waste_Category;
    }

    public boolean isContainsRareMaterials() {
        return containsRareMaterials;
    }

    public void setContainsRareMaterials(boolean containsRareMaterials) {
        this.containsRareMaterials = containsRareMaterials;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() {
        super.toString();
        return (super.toString()+";"+"Electronic" +";" + voltage + ";" + Usability_Status + ";" + E_waste_Category + ";" + containsRareMaterials + ";" + manufacturingDate );
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
