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
public class DATNeighborhood {
    DATConexion c = new DATConexion();
    
    public ResultSet getNeighborhoods() throws SQLException {
        try {
            Statement consulta = c.abrirConexion().createStatement();
            String sql = "SELECT * FROM neighborhood";
            return consulta.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public ResultSet findNeighborhood(String idNeighborhood) throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM NEIGHBORHOOD WHERE IDNEIGHBORHOOD = " + idNeighborhood ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
}
