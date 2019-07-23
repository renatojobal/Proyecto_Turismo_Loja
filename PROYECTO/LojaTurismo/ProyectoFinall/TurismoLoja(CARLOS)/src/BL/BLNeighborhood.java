/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import CLASES.Neighborhood;
import CLASES.Parish;
import DATA.DATNeighborhood;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class BLNeighborhood {

    static BLParish objBLParish = new BLParish();
    ArrayList<Neighborhood> auxListNeigh = new ArrayList<Neighborhood>();
    static DATNeighborhood objDATNeighborhood = new DATNeighborhood();
    
    public void getAllNeihgborhoods() throws SQLException, ClassNotFoundException{
 
        ResultSet rs = objDATNeighborhood.getNeighborhoods();
        while (rs.next()) {
            Neighborhood objNeighborhood = new Neighborhood(rs.getInt(1), rs.getString(2), objBLParish.findParishDB(rs.getString(3)));
            auxListNeigh.add(objNeighborhood);
        }
    }
    
    public ArrayList<Neighborhood> getNeighborhoods(Parish objParish, ArrayList<Neighborhood> listNeighborhoods) throws SQLException, ClassNotFoundException {

        for (Neighborhood neighborhood : auxListNeigh) {
            if (neighborhood.getParish().getIdParish() == objParish.getIdParish()) {
                listNeighborhoods.add(neighborhood);
            }
        }
        return listNeighborhoods;
    }

}
