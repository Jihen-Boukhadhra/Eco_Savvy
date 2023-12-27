/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tassm
 */
public final class Tissu extends Dechet {
    private String color;
    private ArrayList<String> fabricMaterials;

    public Tissu(String color,  String wasteId, boolean isRecyclable, boolean isBiodegradable, double quantityStock, double weight, double lifespan) throws InvalidQuantityException {
        super(wasteId, isRecyclable, isBiodegradable, quantityStock, weight, lifespan);

        if (quantityStock < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative.");
        }
        this.color = color;
        this.fabricMaterials = new ArrayList<>();
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<String> getFabricMaterials() {
        return fabricMaterials;
    }

    public void setFabricMaterials(ArrayList<String> fabricMaterials) {
        this.fabricMaterials = fabricMaterials;
    }
    
    // Method to add a fabric material to the list
    public void addFabricMaterial(String material) {
        fabricMaterials.add(material);
    }

    // Method to search for a fabric material
    public boolean searchMaterial(String material) {
        return fabricMaterials.contains(material);
    }

    // Method to delete a fabric material
    public void deleteMaterial(String material) {
        fabricMaterials.remove(material);
    }

    // Method to modify a fabric material
    public void modifyMaterial(String material, String newMaterial) {
        if (fabricMaterials.contains(material)) {
            int index = fabricMaterials.indexOf(material);
            fabricMaterials.set(index, newMaterial);
        } else {
            System.out.println("Material not found.");
        }
    }

    @Override
    public String toString() {
        super.toString();
        return (super.toString()+";"+"Tissu"+";" + color + ";" + fabricMaterials );
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
