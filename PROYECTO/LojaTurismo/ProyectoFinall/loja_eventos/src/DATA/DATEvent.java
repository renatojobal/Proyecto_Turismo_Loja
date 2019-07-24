/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import CLASES.Events;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Autor: Grupo2
*/
public class DATEvent {
    
    static DATConexion c = new DATConexion();
    
    // Metodo que permite buscar los eventos de un cliente mediante su identificacion
    public static ResultSet findEventsClient(String identification) throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        
        String Sentencia ="select event.idEvent,nameEvent, cost, date, hour, minutes, description, idCat, idPlace, idState from client, event "
                + "where client.idClient = event.idClient and client.identification = "+identification +" order by 1" ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
  
    // Metodo que permite insertar un evento en la DB
    public static boolean insertEvent(Events objEvents, int IdCli) 
             throws ClassNotFoundException, SQLException{
        PreparedStatement ps = null;
        Connection con = c.abrirConexion();
        String sql = "INSERT INTO EVENT(nameEvent, cost, date, hour, minutes, description, idCat, idPlace, idClient, idState, idAdmin) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, objEvents.getName());
            ps.setDouble(2, objEvents.getCost());
            ps.setDate(3, objEvents.getDate());
            ps.setString(4, objEvents.getHour());
            ps.setString(5, objEvents.getMinutes());
            ps.setString(6, objEvents.getDescription());
            ps.setInt(7, objEvents.getCategory().getIdCat());
            ps.setInt(8, objEvents.getPlace().getIdPlace());
            ps.setInt(9, IdCli);
            ps.setInt(10, 1);
            ps.setInt(11, 1);
            ps.execute();
            return true ;
        } catch (Exception e) {
            System.err.println(e);
        }  
        return false;
    } 
    
    // Metodo que actualiza los datos del evento
    public int updateEvent(Events objEvents, Events objTmpEvents) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "UPDATE Event set nameEvent = '" +objTmpEvents.getName() + "'" + ","
                + " cost = '" +objTmpEvents.getCost() +"'" + ","
                + " date = '" +objTmpEvents.getDate() +"'" + ","
                + " hour = '" +objTmpEvents.getHour() +"'" + ","
                + " minutes = '" +objTmpEvents.getMinutes() +"'" + ","
                + " description = '" +objTmpEvents.getDescription() +"'" + ","
                + " idCat = '" +objTmpEvents.getCategory().getIdCat() +"'" + ","
                + " idPlace = '" +objTmpEvents.getPlace().getIdPlace() +
                "' where idEvent = '" + objEvents.getIdEvents()+"'";
        
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
        
    }
    
    // Metodo que permite eliminar un evento
    public int deleteEvent(Events objEvent) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "DELETE FROM Event where idEvent = '" + objEvent.getIdEvents()+"'"; 
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    
    // Metodo para listar los eventos 
    public ResultSet listEventsWhereState(int targetState)  throws ClassNotFoundException, SQLException{
        
        
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM event WHERE event.idState = "+targetState);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
 
    
    }
    
    // Metodo para actualizar el estado del evento 
    public int updateState(Events objEvents) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "UPDATE EVENT set idState = '" +objEvents.getState().getState() + 
                "' where idEvent = '" + objEvents.getIdEvents()+"'";
        
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
        
    }
    
    // Metodo para listar los eventos 
    public ResultSet listEventsCategory(int targetState,int idCat)  throws ClassNotFoundException, SQLException{
        
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM event WHERE event.idState = "+targetState+" and idCat = "+idCat);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
 
    }
    
    /// Metodo para ecnontrar un evento =por su id
    public ResultSet findEventById(int targetId) throws ClassNotFoundException, SQLException{
        
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM event WHERE event.idEvent = "+targetId);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    
    }
    
    


    
}
