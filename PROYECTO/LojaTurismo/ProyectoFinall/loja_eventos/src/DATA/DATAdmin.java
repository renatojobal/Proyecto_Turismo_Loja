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
public class DATAdmin {
    
    
    
    // Metodo que permite buscar el administrador por su usuario
    public ResultSet findIdentification(String user) throws ClassNotFoundException, SQLException
    {
        DATConexion objDATConexion = new DATConexion();
        Statement st = objDATConexion.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM admin WHERE user = '%s'", user);
        ResultSet rs = st.executeQuery(Sentencia);
        objDATConexion.cerrarConexion();
        return rs;
    }
    
}
