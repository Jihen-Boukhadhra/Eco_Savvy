/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecosavy.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author tassm
 */
public sealed class Dechet permits Plastique,Tissu,Verre,Electronic {
    
    protected String wasteId;
    protected boolean isRecyclable;
    protected boolean isBiodegradable;
    protected double quantityStock;
    protected double weight;
    protected double lifespan;

    protected Map<String, Double> chemicalComposition;// chemical material and volume of chemical material such as carbon in each waste.

    public Dechet(String wasteId, boolean isRecyclable, boolean isBiodegradable, double quantityStock, double weight, double lifespan) {

        this.wasteId = wasteId;
        this.isRecyclable = isRecyclable;
        this.isBiodegradable = isBiodegradable;
        this.quantityStock = quantityStock;
        this.weight = weight;
        this.lifespan = lifespan;
        this.chemicalComposition  = new HashMap();

    }

    public Dechet(String wasteId, boolean isRecyclable, boolean isBiodegradable, double quantityStock) {
        this.wasteId = wasteId;
        this.isRecyclable = isRecyclable;
        this.isBiodegradable = isBiodegradable;
        this.quantityStock = quantityStock;
        this.chemicalComposition  = new HashMap();

    }

    public String getWasteId() {
        return wasteId;
    }

    public void setWasteId(String wasteId) {
        this.wasteId = wasteId;
    }

    public boolean isIsRecyclable() {
        return isRecyclable;
    }

    public void setIsRecyclable(boolean isRecyclable) {
        this.isRecyclable = isRecyclable;
    }

    public boolean isIsBiodegradable() {
        return isBiodegradable;
    }

    public void setIsBiodegradable(boolean isBiodegradable) {
        this.isBiodegradable = isBiodegradable;
    }

    public double getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(double quantityStock) throws InvalidQuantityException {
        if (quantityStock < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative.");
        }
        this.quantityStock = quantityStock;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLifespan() {
        return lifespan;
    }

    public void setLifespan(double lifespan) {
        this.lifespan = lifespan;
    }



    public void setChemicalComposition(Map<String, Double> chemicalComposition) {
        this.chemicalComposition = chemicalComposition;
    }

    public boolean isRecyclable() {
        return isRecyclable;
    }

    public void setRecyclable(boolean recyclable) {
        isRecyclable = recyclable;
    }

    public boolean isBiodegradable() {
        return isBiodegradable;
    }

    public void setBiodegradable(boolean biodegradable) {
        isBiodegradable = biodegradable;
    }



    public void addChemicalComponent(String component, Double volume) {
        chemicalComposition.put(component, volume);
    }

    // Method to search for a chemical component and return its volume
    public Double searchComponent(String component) {
        return chemicalComposition.get(component);
    }

    // Method to delete a chemical component
    public void deleteComponent(String component) {
        chemicalComposition.remove(component);
    }

    // Method to modify the volume of a chemical component
    public void modifyComponent(String component, Double newVolume) {
        if (chemicalComposition.containsKey(component)) {
            chemicalComposition.put(component, newVolume);
        } else {
            System.out.println("Component not found.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dechet dechet = (Dechet) o;
        return Double.compare(quantityStock, dechet.quantityStock) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantityStock);
    }
    @Override
    public String toString() {
        return ( wasteId +";"+ isRecyclable + ";"  + isBiodegradable+";"+ quantityStock+";" + weight + ";" + lifespan + ";" + chemicalComposition );
    }

    public Map<String, Double> getChemicalComposition() {
        return chemicalComposition;
    }

}
