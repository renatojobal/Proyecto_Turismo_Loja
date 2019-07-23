package CLASES;
import java.sql.Date;




/**
 * @author Team2
 */
public class State {
    private int idState;
    private int state;
    private String description;

    public State() {
    }

    public State(int idState, int state, String observation) {
        this.idState = idState;
        this.state = state;
        this.description = observation;
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

    
    

 
    


}