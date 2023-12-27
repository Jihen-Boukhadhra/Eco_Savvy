package com.example.ecosavy.Models;

import java.util.LinkedList;
import java.util.List;

public class BoiteCommnts {
    private List<SComment> commnts;

    public BoiteCommnts() {
        commnts = new LinkedList<SComment>();
    }
    public List<SComment> getCommnts(){
        return commnts;
    }
    public void ajouter(SComment sc){
        commnts.add(sc);
    }
}
