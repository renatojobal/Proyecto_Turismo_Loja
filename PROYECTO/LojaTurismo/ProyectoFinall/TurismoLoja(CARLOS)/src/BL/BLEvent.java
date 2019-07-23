/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CLASES.Category;
import java.util.ArrayList;
import java.sql.Date;
import CLASES.Client;
import CLASES.Events;
import CLASES.Place;
import CLASES.State;
import DATA.DATEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Renato
 */
public class BLEvent {
    
    public static ArrayList<Events> ArrayEvents;
    static DATEvent objDATEvents = new DATEvent();
    static BLCategory objBLCategory = new BLCategory();
    static BLPlace objBLPlace = new BLPlace();
    static BLState objBLState = new BLState();
    static Events objEvents = new Events();
    static Place objPlace = new Place();
    // Method to create a client organization
    public Events createEVENT(int idEvents, String name, double cost, Date date, String hour,String minutes,String description, Category category, 
            int idPlace, String principalStreet, String secondaryStreet, String reference, String neighborhood, State state) {
        
        Events newEvent = new Events(idEvents, name, cost, date, hour, minutes, description,category, idPlace, 
                principalStreet, secondaryStreet, reference,neighborhood,state);
        // this.saveInToTextFile(newEve);
        //        this.saveInToDB(newOrg);
        return newEvent;
    }

    public static ArrayList<Events> findEvents(String identification) throws ClassNotFoundException, SQLException {
        ArrayEvents = new ArrayList<Events>();
        ResultSet rs;
        rs = objDATEvents.findEventsClient(identification);
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
            Events e = new Events();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idEvent")) {
                    e.setIdEvents(Integer.parseInt(value));
                }
                if (columnName.equals("nameEvent")) {
                    e.setName(value);
                }
                if (columnName.equals("cost")) {
                    e.setCost(Double.parseDouble(value));
                }
                if (columnName.equals("date")) {
                    e.setDate(Date.valueOf(value));
                }
                if (columnName.equals("hour")) {
                    e.setHour(value);
                }
                if (columnName.equals("minutes")) {
                    e.setMinutes(value);
                }
                if (columnName.equals("description")) {
                    e.setDescription(value);
                }
                if (columnName.equals("idCat")) {
                    e.setCategory(objBLCategory.findCategoryDB(value));
                }
                if (columnName.equals("idPlace")) {
                    e.setPlace(objBLPlace.findPlaceDB(value));
                }
                if (columnName.equals("idState")) {
                    e.setState(objBLState.findStateDB(value));
                }
            }
            ArrayEvents.add(e);
        }
        return ArrayEvents;
    }

    public static void insertEvent(Client objClient) throws ClassNotFoundException, SQLException {
        objPlace = objClient.getArrayEvents().get(objClient.getArrayEvents().size() - 1).getPlace();
        objBLPlace.insertPlaceDB(objPlace);
        objClient.getArrayEvents().get(objClient.getArrayEvents().size() - 1).setPlace(objBLPlace.finLastRowDB());
        objEvents = objClient.getArrayEvents().get(objClient.getArrayEvents().size() - 1);
        objDATEvents.insertEvent(objEvents, objClient.getIdClient());
    }
    
    
    public Events updateEventDB(Events ObjEvents, Events objTmpEvents) throws SQLException, ClassNotFoundException{
        int intRetorno =0;
        objTmpEvents.setPlace(objBLPlace.updatePlaceDB(ObjEvents.getPlace(), objTmpEvents.getPlace()));
        intRetorno = objDATEvents.updateEvent(ObjEvents,objTmpEvents);
        return ObjEvents;
    }
    
    public Events deleteEventDB(Events ObjEvents) throws SQLException, ClassNotFoundException{
        int intRetorno =0;
        intRetorno = objDATEvents.deleteEvent(ObjEvents);
        objBLPlace.deletePlaceDB(ObjEvents.getPlace());
        return ObjEvents;
    }
    
    public Events ActualizarClient(Events ObjEvents, String name, double cost, Date date, String description, String category,
            String principalStreet, String secondaryStreet, String reference) {

        ObjEvents.setName(name);
        ObjEvents.setCost(cost);
        ObjEvents.setDate(date);
        ObjEvents.setDescription(description);
//        ObjEvents.setCategory(category);
        ObjEvents.getPlace().setPrincipalStreet(principalStreet);
        ObjEvents.getPlace().setSecondaryStreet(secondaryStreet);
        ObjEvents.getPlace().setReference(reference);
        return ObjEvents;
    }

//    // Method to save into the data base
//    public void saveInToDB(Organization organization){
//        
//        
//    }
    // Metodo para listar los eventos de acuerdo a un estado
    public ArrayList<Events> listEventsWhereState(int targetState) {
        ArrayList<Events> arrayEvents = new ArrayList<>();

        try {
            ResultSet rs = objDATEvents.listEventsWhereState(targetState);

            while (rs.next()) {
                // Obtenemos los atributos del ResultSet
                int idEvents = rs.getInt("idEvent");
                String name = rs.getString("nameEvent");
                double cost = rs.getDouble("cost");
                Date date = rs.getDate("date");
                String hour = rs.getString("hour");
                String minutes = rs.getString("minutes");
                String description = rs.getString("description");
                Category category = null;
                Place place = null;
                State state =null;
                
                int idCat = rs.getInt("idCat");
                int idPlace = rs.getInt("idPlace");
    
                
                // Cargamos los atributos de categoria, lugar y cliente por su id
                category =  objBLCategory.findCategoryDB(String.valueOf(idCat));
                place = objBLPlace.findPlaceDB(String.valueOf(idPlace));
                Events objEvents = new Events(idEvents, name, cost, date, hour, minutes, description, category, place, state);
                arrayEvents.add(objEvents);
            }
             
            // Retornarmos el eventos
            return arrayEvents;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    // Metodo para listar los eventos de acuerdo a un estado
    public ArrayList<Events> listEventsCategory(int targetState, Category objCategory) {
        ArrayList<Events> arrayEvents = new ArrayList<>();

        try {
            ResultSet rs = objDATEvents.listEventsCategory(targetState, objCategory.getIdCat());

            while (rs.next()) {
                // Obtenemos los atributos del ResultSet
                int idEvents = rs.getInt("idEvent");
                String name = rs.getString("nameEvent");
                double cost = rs.getDouble("cost");
                Date date = rs.getDate("date");
                String hour = rs.getString("hour");
                String minutes = rs.getString("minutes");
                String description = rs.getString("description");
                Category category = null;
                Place place = null;
                State state =null;
                
                int idCat = rs.getInt("idCat");
                int idPlace = rs.getInt("idPlace");
    
                
                // Cargamos los atributos de categoria, lugar y cliente por su id
                category =  objBLCategory.findCategoryDB(String.valueOf(idCat));
                place = objBLPlace.findPlaceDB(String.valueOf(idPlace));
                Events objEvents = new Events(idEvents, name, cost, date, hour, minutes, description, category, place, state);
                arrayEvents.add(objEvents);
            }
             
            // Retornarmos el eventos
            return arrayEvents;
        } catch (Exception e) {
            System.out.println("Hola");
            //System.out.println(e);
        }
        return null;
    }

}
