/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import CLASES.Neighborhood;
import CLASES.Parish;
import DATA.DATNeighborhood;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class BLNeighborhood {

    static BLParish objBLParish = new BLParish();
    static DATNeighborhood objDATNeighborhood = new DATNeighborhood();
    
    public ArrayList<Neighborhood> getAllNeihgborhoods() throws SQLException, ClassNotFoundException{
        ArrayList<Neighborhood> auxListNeigh = new ArrayList<Neighborhood>();
        ResultSet rs = objDATNeighborhood.getNeighborhoods();
        while (rs.next()) {
            Neighborhood objNeighborhood = new Neighborhood(rs.getInt(1), rs.getString(2), objBLParish.findParishDB(rs.getString(3)));
            auxListNeigh.add(objNeighborhood);
        }
        return auxListNeigh;
    }
    
    public ArrayList<Neighborhood> getNeighborhoods(Parish objParish, ArrayList<Neighborhood> listNeighborhoods) throws SQLException, ClassNotFoundException {
        
        ArrayList<Neighborhood> auxListNeigh = new ArrayList<Neighborhood>();
        for (Neighborhood neighborhood : listNeighborhoods) {
            if (neighborhood.getParish().getIdParish() == objParish.getIdParish()) {
                
                auxListNeigh.add(neighborhood);
            }
            
        }
        return auxListNeigh;
    }
    
    public Neighborhood findNeighborhoodDB(String idNeighborhood) throws ClassNotFoundException, SQLException 
    {
        Neighborhood objNeighborhood = new Neighborhood();
        ResultSet rs = objDATNeighborhood.findNeighborhood(idNeighborhood);
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
                if (columnName.equals("idNeighborhood"))
                    objNeighborhood.setIdNeighborhood(Integer.parseInt(value));
                if (columnName.equals("name"))
                    objNeighborhood.setName(value);
                if (columnName.equals("idParish"))
                    objNeighborhood.setParish(objBLParish.findParishDB(value));
            }           
        }
        return objNeighborhood;
    }

}
