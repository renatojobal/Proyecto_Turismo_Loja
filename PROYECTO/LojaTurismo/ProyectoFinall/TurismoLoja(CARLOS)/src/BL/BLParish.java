/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import CLASES.Parish;

import DATA.DATNeighborhood;
import DATA.DATParish;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class BLParish {
    static DATParish objDatParish = new DATParish();
    
    public void getParishes(ArrayList<Parish> listParish) throws SQLException {
        
        DATNeighborhood objDATNeighborhood = new DATNeighborhood();
        ResultSet rs = objDatParish.getParishes();
        while (rs.next()) {
            Parish objParish = new Parish(rs.getInt(1), rs.getString(2));
            listParish.add(objParish);
        }
    }
    
    public Parish findParishDB(String idParish) throws ClassNotFoundException, SQLException 
    {
        Parish objParish = new Parish();
        ResultSet rs = objDatParish.findParish(idParish);
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
                if (columnName.equals("idParish"))
                    objParish.setIdParish(Integer.parseInt(value));
                if (columnName.equals("name"))
                    objParish.setName(value);
            }           
        }
        return objParish;
    }
    
}
