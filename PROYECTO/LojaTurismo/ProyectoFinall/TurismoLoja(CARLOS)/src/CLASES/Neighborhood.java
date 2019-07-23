/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

/**
 *
 * @author carlo
 */
public class Neighborhood {
    
    private int idNeighborhood;
    private String name;
    private Parish parish;

    public Neighborhood() {
    }

    public Neighborhood(int idNeighborhood, String name, Parish parish) {
        this.idNeighborhood = idNeighborhood;
        this.name = name;
        this.parish = parish;
    }

    public int getIdNeighborhood() {
        return idNeighborhood;
    }

    public void setIdNeighborhood(int idNeighborhood) {
        this.idNeighborhood = idNeighborhood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parish getParish() {
        return parish;
    }

    public void setParish(Parish parish) {
        this.parish = parish;
    }
    
    
    @Override
    public String toString() {
        return String.format("%s", this.getName());
    }
}
