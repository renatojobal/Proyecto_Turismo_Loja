/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;


import CLASES.Place;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Renato
 */
public class DATPlace {
    
    static DATConexion c = new DATConexion();
    
    public ResultSet findPlace(String idPlace) throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM PLACE WHERE IDPLACE = " + idPlace ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    
    public static int insertPlace(Place objPlace) throws ClassNotFoundException, SQLException{
        int intRetorno=0;
        Statement st = c.getConnection().createStatement();
        String Sentencia = "INSERT InTO Place (principalStreet, secondaryStreet, reference, idNeighborhood)  VALUES ( " 
                +"'" +objPlace.getPrincipalStreet()+"'"  + "," 
                +"'" +objPlace.getSecondaryStreet()+"'" + ","
                +"'" +objPlace.getReference()+"'" + ","
                + objPlace.getNeighborhood().getIdNeighborhood() + ")" ;
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    public int updatePlace(Place objPlace, Place objTmpPlace) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "UPDATE Place set principalStreet = '" +objTmpPlace.getPrincipalStreet() + "'" + ","
                + " secondaryStreet = '" +objTmpPlace.getSecondaryStreet() +"'" + ","
                + " reference = '" +objTmpPlace.getReference() +"'" + ","
                + " idNeighborhood = '" +objTmpPlace.getNeighborhood() +
                "' where idPlace = '" + objPlace.getIdPlace()+"'";
        
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
        
    }
    
    public int deleteEvent(Place objPlace) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "DELETE FROM Place where idPlace = '" + objPlace.getIdPlace()+"'"; 
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
//    public int Insertar(Place objPlace) throws SQLException, ClassNotFoundException{
//        int intRetorno=0;
//        Statement st = c.getConnection().createStatement();
//        String Sentencia = "INSERT InTO Place (principalStreet, secondaryStreet, reference, idNeighborhood)  VALUES ( " 
//                +"'" +objPlace.getPrincipalStreet()+"'"  + "," 
//                +"'" +objPlace.getSecondaryStreet()+"'" + ","
//                +"'" +objPlace.getReference()+"'" + ","
//                + objPlace.getNeighborhood().getIdNeighborhood() + ")" ;
//        intRetorno = st.executeUpdate(Sentencia);
//        return intRetorno;
//    }
    
    public ResultSet findLastRow() throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM place WHERE idPlace=(SELECT MAX(idPlace) FROM place)"  ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
}
