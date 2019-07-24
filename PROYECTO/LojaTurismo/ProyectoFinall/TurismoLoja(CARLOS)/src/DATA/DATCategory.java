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
public class DATCategory {
    
    DATConexion objDATConexion = new DATConexion();
    
    public ResultSet findCategory(String idCategory) throws ClassNotFoundException, SQLException
    {
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM CATEGORY WHERE IDCAT = " + idCategory ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    
    public ResultSet getCategories() throws SQLException {
    
        try {
            Statement consulta = objDATConexion.getConnection().createStatement();
            String sql = "SELECT * FROM CATEGORY";
            return consulta.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            return null;
        }
   
    }
    
       // Metodo que busca una configuracion por su id
    public ResultSet searchCategoryById(int idCategory) throws SQLException, ClassNotFoundException{
        Statement st = objDATConexion.getConnection().createStatement();
        String sentenceSQL = String.format("SELECT * FROM `category` WHERE `idCat` = %d",idCategory) ;
        ResultSet rs = st.executeQuery(sentenceSQL);
        return rs;
    }

    // Metodo par alistar las cetegorias
    public ResultSet listCategories() throws SQLException, ClassNotFoundException{
        Statement st = objDATConexion.getConnection().createStatement();
        String sentenceSQL = "SELECT * FROM `category`";
        ResultSet rs = st.executeQuery(sentenceSQL);
        return rs; 
    }
}
