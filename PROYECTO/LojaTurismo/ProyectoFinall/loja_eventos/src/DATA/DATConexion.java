/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Autor: Grupo2
*/
public class DATConexion {

    public Connection con;
    
    // Metodo que permite realizar la conexion con la DB
    public Connection getConnection() throws SQLException, ClassNotFoundException{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/turismo_loja"; // Nombre de la base de datos
            Class.forName(driver);
            return DriverManager.getConnection(url,"root","");
    };
    
    public Connection abrirConexion() throws ClassNotFoundException, SQLException
    {
        con = getConnection();
        return con;
    }
    
    public void cerrarConexion() throws SQLException
    {
       con.close();
    }

}
