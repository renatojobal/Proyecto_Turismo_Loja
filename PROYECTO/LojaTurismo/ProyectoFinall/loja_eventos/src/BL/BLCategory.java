/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import CLASES.Category;
import DATA.DATCategory;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/*
Autor: Grupo2
*/

public class BLCategory {
    
    DATCategory objDATCategory = new DATCategory();
    
    // Metodo que permite buscar una categoria por su id
    public Category findCategoryDB(String idCat) throws ClassNotFoundException, SQLException 
    {
        Category objCategory = new Category(); // Creamos el objeto categoria
        ResultSet rs = objDATCategory.findCategory(idCat);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        //Envia los datos al objeto
        while (rs.next()) {
            for (String columnName : columns){
                String value = rs.getString(columnName);
                 if (columnName.equals("idCat"))
                    objCategory.setIdCat(Integer.parseInt(value));
                if (columnName.equals("categoryName"))
                    objCategory.setCategoryName(value);
            }           
        }
        return objCategory;
    }
    
    // Metodo que obtiene todas las categorias
    public void getCategories(ArrayList<Category> listCategories) throws SQLException {
        DATCategory objDATCategory = new DATCategory();
        ResultSet rs = objDATCategory.getCategories();
        // Llenamos el objeto
        while (rs.next()) {
            Category objCategory = new Category(rs.getInt(1), rs.getString(2));
            listCategories.add(objCategory);
        }
    }
    
    

    // Metodo para buscar una categora por su id
    public Category searchCategoryById(int idCat){
        try {
            // Obtenemos el resultSet
            ResultSet rs = objDATCategory.searchCategoryById(idCat);
            
            // Creamos el objeto
            String categoryName = rs.getString("categoryName");
                        System.out.println("Holaaa");
            Category objCategory = new Category(idCat, categoryName);

            return objCategory;
        } catch (Exception e) {
            System.err.println("Ha ocurrido una excepcion en el metodo 'searchCategoryById' de la clase 'BLCategory'"+e);
            return null;
        }
    
    }
    
    // Metodo para listar las categorias
    public ArrayList<Category> listCategories(){
        ArrayList<Category> categoriesArray = new ArrayList();
        try {
            ResultSet rs = objDATCategory.listCategories();

            while (rs.next()) {
                
                // Obtenemos los datos del rs
                int idCat = rs.getInt("idCat");
                String categoryName = rs.getString("categoryName");

                // Creamos un objeto state
                Category objCategory = new Category(idCat, categoryName);

                // Lo agregamos al array
                categoriesArray.add(objCategory);
            }
            return categoriesArray;
        } catch (Exception e) {
            System.err.println("Ha ocurrido una excepcion en el metodo 'listCategories' de la clase 'BLCategory'"+e);
            return null;
            
        }
        
        
    
    }
    
}
