/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Renato
 */
public class DATState {

    static DATConexion objDATConexion = new DATConexion();

    public ResultSet findState(String idState) throws ClassNotFoundException, SQLException {
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM `state` WHERE `idState` = " + idState;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet findState(int idState) throws ClassNotFoundException, SQLException {
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM `state` WHERE `idState` = %d", idState);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
  
    public ResultSet getStates() throws SQLException {
        try {
            Statement consulta = objDATConexion.getConnection().createStatement();
            String sql = "SELECT * FROM STATE";
            return consulta.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            return null;
        }
   
    }

}
