/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import CLASES.Category;
import CLASES.State;
import DATA.DATState;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Carlos
 */
public class BLState {
    
    static DATState objDATState = new DATState();
    
    public State findStateDB(String idPlace) throws ClassNotFoundException, SQLException 
    {
        State objState = new State();
        ResultSet rs = objDATState.findState(idPlace);
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
                if (columnName.equals("idState"))
                    objState.setIdState(Integer.parseInt(value));
                if (columnName.equals("state"))
                    objState.setState(Integer.parseInt(value));
                if (columnName.equals("description"))
                    objState.setDescription(value);
            }           
        }
        return objState;
    }
    
    
    
    
    public void getCategories(ArrayList<State> listStates) throws SQLException {
        DATState objDatSate = new DATState();
        ResultSet rs = objDatSate.getStates();
        while (rs.next()) {
            State objState = new State(rs.getInt(1), rs.getInt(2),rs.getString(3));
            listStates.add(objState);
        }
    }
}
