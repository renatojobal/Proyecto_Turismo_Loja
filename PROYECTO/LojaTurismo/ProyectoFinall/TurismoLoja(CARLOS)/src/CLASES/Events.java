package CLASES;


import java.sql.Date;

/**Date fechaActual = new java.sql.Date(0);
 * @author Team2
 */
public class Events {
    
    private int idEvents;
    private String name;
    private double cost;
    private Date date;
    private String hour;
    private String minutes;
    private String description;
    private Category category;
    private Place place;
    private State state;
    
    public Events() {
    }

    public Events(int idEvents, String name, double cost, Date date, String hour,String minutes,String description, Category category, 
            int idPlace, String principalStreet, String secondaryStreet, String reference, Neighborhood neighborhood, State state) {
        this.idEvents = idEvents;
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.hour = hour;
        this.minutes = minutes;
        this.description = description;
        this.category = category;
        this.place = new Place(idPlace, principalStreet, secondaryStreet, reference, neighborhood);
        this.state = state;
        
    }

    public Events(int idEvents, String name, double cost, Date date, String hour, String minutes, String description, Category category, Place place, State state) {
        this.idEvents = idEvents;
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.hour = hour;
        this.minutes = minutes;
        this.description = description;
        this.category = category;
        this.place = place;
        this.state = state;
    }

    
    
    public int getIdEvents() {
        return idEvents;
    }

    public void setIdEvents(int idEvents) {
        this.idEvents = idEvents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }  

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Events{" + "idEvents=" + idEvents + ", name=" + name + ", cost=" + cost + ", date=" + date + ", "
                + "hour=" + hour + ", minutes=" + minutes + ", description=" + description + ", category=" + category + ", "
                + "place=" + place + ", state=" + state + '}';
    }
   
    
    
}