/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

/*
Autor: Grupo2
*/
public class Category {
    
    private int idCat;
    private String categoryName;
    
    // Constructor Vacio
    public Category() {
    }

    // Constructor sobre cargado
    public Category(int idCat, String categoryName) {
        this.idCat = idCat;
        this.categoryName = categoryName;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    // Sobre escribimos el metodo toString
    @Override
    public String toString() {
        return String.format("%s", this.getCategoryName());
    }

    
    
    
}
