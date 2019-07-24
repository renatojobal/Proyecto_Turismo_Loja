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
public class DATParish {

    // Metodo que permite obtener todas las parroquias desde la DB
    public ResultSet getParishes() throws SQLException {
        DATConexion objDATConexion = new DATConexion();
        try {
            Statement consulta = objDATConexion.abrirConexion().createStatement();
            String sql = "SELECT * FROM parish";
            objDATConexion.cerrarConexion();
            return consulta.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            objDATConexion.cerrarConexion();
            return null;
        }

    }

    // Metodo que permite obtener una parroquia por su id
    public ResultSet findParish(String idParish) throws ClassNotFoundException, SQLException {
        DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM PARISH WHERE IDPARISH= " + idParish;
        ResultSet rs = st.executeQuery(Sentencia);
        objDATConexion.cerrarConexion();
        return rs;
    }

}
