/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import CLASES.Admin;
import DATA.DATAdmin;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Renato
 */
public class BLAdmin {
    
    DATA.DATAdmin objDatAdmin = new DATAdmin();
    BLEncrypt objBLEncrypt = new BLEncrypt();
    
    // Metodo que permite buscar el administrador por su user
    public Admin findAdminIdentificationDB(String user) throws ClassNotFoundException, SQLException 
    {
        Admin objAdmin = new Admin(); // Creamos el nuevo objeto administrador
        ResultSet rs = objDatAdmin.findIdentification(user);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        //Envia los datos al objeto
        while (rs.next()) {
            for (String columnName : columns){
                String value = rs.getString(columnName);
                 if (columnName.equals("idAdmin"))
                    objAdmin.setIdAdmin(Integer.parseInt(value));
                if (columnName.equals("user"))
                    objAdmin.setUser(value);
                if (columnName.equals("password"))
                    objAdmin.setPassword(value);                             
            }           
        }
        return objAdmin; // retorna el objeto administrador
    }
    
    // Metodo que permite validar la contraseña del administrador
    public Admin ValidatePassword(Admin objAdmin, String targetPassword) {
        
        // Se encripta la contraseña ingresada y se la compara con la contraseña registrada 
        if (objAdmin.getPassword().equals(objBLEncrypt.getEncrypt(targetPassword))) {
            return objAdmin;
        }
        return null;
    }
    
}
