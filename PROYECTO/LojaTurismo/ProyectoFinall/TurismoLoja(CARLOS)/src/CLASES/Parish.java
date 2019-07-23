/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Parish {
    
    private int idParish;
    private String name;
    private ArrayList<Neighborhood> arrayNeighborhoods = new ArrayList<Neighborhood>();

    public Parish() {
    }

    public Parish(int idParish, String name) {
        this.idParish = idParish;
        this.name = name;
    }

    public int getIdParish() {
        return idParish;
    }

    public void setIdParish(int idParish) {
        this.idParish = idParish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Neighborhood> getArrayNeighborhoods() {
        return arrayNeighborhoods;
    }

    public void setArrayNeighborhoods(ArrayList<Neighborhood> arrayNeighborhoods) {
        this.arrayNeighborhoods = arrayNeighborhoods;
    }
    
    @Override
    public String toString() {
        return String.format("%s", this.getName());
    }
    
    
}
