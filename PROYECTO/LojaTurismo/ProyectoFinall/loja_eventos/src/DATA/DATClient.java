/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import CLASES.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Autor: Grupo2
*/
public class DATClient {
    
    DATConexion c = new DATConexion();
    
    // Metodo que permite insertar un cliente en la DB
    public int insertClient(Client ObjCli) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.getConnection().createStatement();
        String Sentencia = "INSERT InTO Client (identification, password, names, lastNames, mail, numberPhone)  VALUES ( " 
                +"'" +ObjCli.getIdentification()+"'"  + "," 
                +"'" +ObjCli.getPassword()+"'" + ","
                +"'" +ObjCli.getNames()+"'" + ","
                +"'" +ObjCli.getLastnames()+"'" + ","
                +"'" +ObjCli.getMail()+"'" + ","
                + ObjCli.getNumberPhone() + ")" ;
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    
    // Metodo que permite buscar el cliente por su identificacion
    public ResultSet findIdentification(String identification) throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM client WHERE IDENTIFICATION = " + identification ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    // Metodo que actualiza los datos del cliente
    public int updateClient(Client objClient, Client objTmpClient) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "UPDATE Client set identification  = '" +objTmpClient.getIdentification() + "'" + ","
                + " password = '" +objTmpClient.getPassword() +"'" + ","
                + " names = '" +objTmpClient.getNames() +"'" + ","
                + " lastNames = '" +objTmpClient.getLastnames() +"'" + ","
                + " mail = '" +objTmpClient.getMail() +"'" + ","
                + " numberPhone = '" + objTmpClient.getNumberPhone() + 
                "' where identification = '" + objClient.getIdentification()+"'";
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;       
    }
    
}
