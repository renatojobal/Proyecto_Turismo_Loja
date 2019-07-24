/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

/*
Autor: Grupo2
*/

import CLASES.Place;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Autor: Grupo2
*/
public class DATPlace {
    
 
    
    // Metodo que permite obtener la direccion de un evento por su id
    public ResultSet findPlace(String idPlace) throws ClassNotFoundException, SQLException
    {DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM PLACE WHERE IDPLACE = " + idPlace ;
        ResultSet rs = st.executeQuery(Sentencia);
        objDATConexion.cerrarConexion();
        return rs;
    }
    
    // Metodo que inserta una nueva direccion en la DB
    public int insertPlace(Place objPlace) throws ClassNotFoundException, SQLException{
        int intRetorno=0;
        DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.getConnection().createStatement();
        String Sentencia = "INSERT InTO Place (principalStreet, secondaryStreet, reference, idNeighborhood)  VALUES ( " 
                +"'" +objPlace.getPrincipalStreet()+"'"  + "," 
                +"'" +objPlace.getSecondaryStreet()+"'" + ","
                +"'" +objPlace.getReference()+"'" + ","
                + objPlace.getNeighborhood().getIdNeighborhood() + ")" ;
        intRetorno = st.executeUpdate(Sentencia);
        objDATConexion.cerrarConexion();
        return intRetorno;
    }
    
    // Metodo que actualiza los datos de la direccion en la DB
    public int updatePlace(Place objPlace, Place objTmpPlace) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = "UPDATE Place set principalStreet = '" +objTmpPlace.getPrincipalStreet() + "'" + ","
                + " secondaryStreet = '" +objTmpPlace.getSecondaryStreet() +"'" + ","
                + " reference = '" +objTmpPlace.getReference() +"'" + ","
                + " idNeighborhood = '" +objTmpPlace.getNeighborhood().getIdNeighborhood() +
                "' where idPlace = '" + objPlace.getIdPlace()+"'";
        
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
        
    }
    
    // Metodo que permite eliminar una direccion
    public int deleteEvent(Place objPlace) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = "DELETE FROM Place where idPlace = '" + objPlace.getIdPlace()+"'"; 
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }

    // Metodo que permite obtener la ultima direccion registrada en la DB
    public ResultSet findLastRow() throws ClassNotFoundException, SQLException
    {
        DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM place WHERE idPlace=(SELECT MAX(idPlace) FROM place)"  ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
}
