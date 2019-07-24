package CLASES;
import java.sql.Date;




/*
Autor: Grupo2
*/
public class State {
    private int idState;
    private int state;
    private String description;

    // Constructor Vacio
    public State() {
    }
    
    // Constructor sobre cargado
    public State(int idState, int state, String observation) {
        this.idState = idState;
        this.state = state;
        this.description = observation;
    }
    
    public void updateState(int state){
        this.state = state;
    }
                
                
    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String observation) {
        this.description = observation;
    }

    // Sobre escribimos el metodo toString
    @Override
    public String toString() {
        return String.format("%s", this.getDescription());
    }

 
    


}