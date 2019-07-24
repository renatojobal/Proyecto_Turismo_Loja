package CLASES;

import java.sql.Date;
import java.util.ArrayList;

/*
Autor: Grupo2
*/

public class Client {
    
    private int idClient;
    private String identification;
    private String password;
    private String names;
    private String lastnames;
    private String mail;
    private String numberPhone;
    private ArrayList<Events> arrayEvents = new ArrayList<>();
    

    public Client() {
    }

    public Client(int idClient,String identification, String password, String names, String lastnames, String mail, String numberPhone) {
        this.idClient = idClient;
        this.identification = identification;
        this.password = password;
        this.names = names;
        this.lastnames = lastnames;
        this.mail = mail;
        this.numberPhone = numberPhone;
    }
    
    
    // Constructor donde se representa composicion;
    public Client(int idClient,String identification, String password, String names, String lastnames, String mail, String numberPhone,
            int idEvents, String name, double cost, Date date, String hour, String minutes, String description, Category category,
            int idPlace, String principalStreet, String secondaryStreet, String reference,Neighborhood neighborhood, State state) {
        this.idClient = idClient;
        this.identification = identification;
        this.password = password;
        this.names = names;
        this.lastnames = lastnames;
        this.mail = mail;
        this.numberPhone = numberPhone;
        // Composicion
        arrayEvents.add(new Events(idEvents, name, cost, date, hour, minutes,description, 
                category,idPlace, principalStreet, secondaryStreet, reference, neighborhood, state));
    }
    
    // Metodo que permite agregar un evento a un cliente
    public void setEvent(int idEvents, String name, double cost, Date date, String hour, String minutes, String description, Category category,
            int idPlace, String principalStreet, String secondaryStreet, String reference, Neighborhood neighborhood, State state){
        
        arrayEvents.add(new Events(idEvents, name, cost, date, hour, minutes, description, 
                category, idPlace, principalStreet, secondaryStreet, reference, neighborhood, state));
    }
    
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public ArrayList<Events> getArrayEvents() {
        return arrayEvents;
    }

    public void setArrayEvents(ArrayList<Events> arrayEvents) {
        this.arrayEvents = arrayEvents;
    }
    
    // Sobre escribimos el metodo toString
    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", identification=" + identification + ", password=" + password + ", names=" + names + ", lastnames=" + lastnames + ", mail=" + mail + ", numberPhone=" + numberPhone + ", arrayEvents=" + arrayEvents.toString() + '}';
    }

    

   

    

    
    




}