package CLASES;
import java.util.*;

/**
 * @author Team2
 */
public class Place {
    
    public int idPlace;
    private String principalStreet;
    private String secondaryStreet;
    private String reference;
    private Neighborhood neighborhood;
    


    public Place() {
    }

    public Place(int idPlace, String principalStreet, String secondaryStreet, String reference, Neighborhood neighborhood) {
        this.idPlace = idPlace;
        this.principalStreet = principalStreet;
        this.secondaryStreet = secondaryStreet;
        this.reference = reference;
        this.neighborhood = neighborhood;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public String getPrincipalStreet() {
        return principalStreet;
    }

    public void setPrincipalStreet(String principalStreet) {
        this.principalStreet = principalStreet;
    }

    public String getSecondaryStreet() {
        return secondaryStreet;
    }

    public void setSecondaryStreet(String secondaryStreet) {
        this.secondaryStreet = secondaryStreet;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    @Override
    public String toString() {
        return "Place{" + "idPlace=" + idPlace + ", principalStreet=" + principalStreet + ", secondaryStreet=" + secondaryStreet + ", reference=" + reference + ", neighborhood=" + neighborhood.getIdNeighborhood() + '}';
    }


}