package CLASES;
import java.util.*;

public class Admin {

    private int idAdmin;
    private String user;
    private String password;
    private ArrayList<Events> arrayEvents;

    public Admin() {
    }
    
   
    
    public Admin(int idAdmin, String user, String password, Events arrEvents) {
        this.idAdmin = idAdmin;
        this.user = user;
        this.password = password;
        this.arrayEvents = arrayEvents;
    }
    
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Events> getArrayEvents() {
        return arrayEvents;
    }

    public void setArrayEvents(ArrayList<Events> arrayEvents) {
        this.arrayEvents = arrayEvents;
    }

    @Override
    public String toString() {
        return "Admin{" + "idAdmin=" + idAdmin + ", user=" + user + ", password=" + password + ", arrayEvents=" + arrayEvents + '}';
    }

    
    
}