/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import static BL.BLEvent.objDATEvents;
import CLASES.Events;
import CLASES.Place;
import DATA.DATPlace;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Renato
 */
public class BLPlace {
    
    static DATPlace objDatPlace = new DATPlace();
    static BLNeighborhood objBLNeighborhood = new BLNeighborhood();
    
    public Place findPlaceDB(String idPlace) throws ClassNotFoundException, SQLException 
    {
        Place objPlace = new Place();
        ResultSet rs = objDatPlace.findPlace(idPlace);
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
                if (columnName.equals("idPlace"))
                    objPlace.setIdPlace(Integer.parseInt(value));
                if (columnName.equals("principalStreet"))
                    objPlace.setPrincipalStreet(value);
                if (columnName.equals("secondaryStreet"))
                    objPlace.setSecondaryStreet(value);
                if (columnName.equals("reference")){
                    objPlace.setReference(value);
                }
                if (columnName.equals("idNeighborhood")){
                    objPlace.setNeighborhood(objBLNeighborhood.findNeighborhoodDB(value));
                }
            }
            
        }
        return objPlace;
    }
    
    public static boolean insertPlaceDB(Place objPlace) throws SQLException, ClassNotFoundException{
        
        objDatPlace.insertPlace(objPlace);
        return false;
    }
    
    public Place updatePlaceDB(Place objPlace, Place objTmpPlace) throws SQLException, ClassNotFoundException{
        int intRetorno =0;
        intRetorno = objDatPlace.updatePlace(objPlace,objTmpPlace);
        return objPlace;
    }
    
    public Place deletePlaceDB(Place objPlace) throws SQLException, ClassNotFoundException{
        int intRetorno =0;
        intRetorno = objDatPlace.deleteEvent(objPlace);
        return objPlace;
    }
    
    public Place finLastRowDB() throws ClassNotFoundException, SQLException 
    {
        Place objPlace = new Place();
        ResultSet rs = objDatPlace.findLastRow();
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
                if (columnName.equals("idPlace"))
                    objPlace.setIdPlace(Integer.parseInt(value));
                if (columnName.equals("principalStreet"))
                    objPlace.setPrincipalStreet(value);
                if (columnName.equals("secondaryStreet"))
                    objPlace.setSecondaryStreet(value);
                if (columnName.equals("reference"))
                    objPlace.setReference(value);
                if (columnName.equals("neighborhood"))
                    objPlace.setNeighborhood(objBLNeighborhood.findNeighborhoodDB(value));
            }           
        }
        return objPlace;
    }
    
    
    
}
