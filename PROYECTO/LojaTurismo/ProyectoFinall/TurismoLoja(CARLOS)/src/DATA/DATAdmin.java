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
public class DATAdmin {
    
    DATConexion c = new DATConexion();
    
//    public ResultSet findIdentification(String user) throws ClassNotFoundException, SQLException
//    {
//        Statement st = c.abrirConexion().createStatement();
//        String Sentencia = "SELECT * FROM ADMIN WHERE dsad = " + user ;
//        ResultSet rs = st.executeQuery(Sentencia);
//        return rs;
//    }
    
    
    
    public ResultSet findIdentification(String user) throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM admin WHERE user = '%s'", user);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
}
