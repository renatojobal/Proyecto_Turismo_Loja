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
 * @author carlo
 */
public class DATParish {
    DATConexion c = new DATConexion();
    
    
    public ResultSet getParishes() throws SQLException {
        try {
            Statement consulta = c.abrirConexion().createStatement();
            String sql = "SELECT * FROM parish";
            return consulta.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            return null;
        }
   
    }
    
    public ResultSet findParish(String idParish) throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM PARISH WHERE IDPARISH= " + idParish ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
}
