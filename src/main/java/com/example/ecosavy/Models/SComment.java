package com.example.ecosavy.Models;

public record SComment(String ID_Comment, String libelle, String auteur, String contenu, int nbEtoiles) implements Comparable<SComment> {


    @Override
    public int compareTo(SComment o) {
        return this.nbEtoiles-o.nbEtoiles;
    }
}
