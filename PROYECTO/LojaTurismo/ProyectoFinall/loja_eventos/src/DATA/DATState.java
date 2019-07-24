/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Autor: Grupo2
*/
public class DATState {



    // Metodo que permite buscar un estado por su Id
    public ResultSet findState(String idState) throws ClassNotFoundException, SQLException {
        DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM `state` WHERE `idState` = " + idState;
        ResultSet rs = st.executeQuery(Sentencia);
        objDATConexion.cerrarConexion();
        return rs;
    }

    public ResultSet findState(int idState) throws ClassNotFoundException, SQLException {
        DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM `state` WHERE `idState` = %d", idState);
        ResultSet rs = st.executeQuery(Sentencia);
        objDATConexion.cerrarConexion();
        return rs;
    }
    
    // Metodo que permite obtener todos estados de la DB
    public ResultSet getStates() throws SQLException {
        DATConexion objDATConexion = new DATConexion();
        try {
            Statement consulta = objDATConexion.getConnection().createStatement();
            String sql = "SELECT * FROM STATE";
            objDATConexion.cerrarConexion();
            return consulta.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            objDATConexion.cerrarConexion();
            return null;
        }
   
    }

}
