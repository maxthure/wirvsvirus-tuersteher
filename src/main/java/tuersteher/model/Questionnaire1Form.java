package tuersteher.model;

/**
 * @author Thure Nebendahl on 21.03.20
 */
public class Questionnaire1Form {
    private Trip trip;
    private Passenger driver;

    public Questionnaire1Form(){
        trip = new Trip();
        driver = new Passenger();
        trip.setCar(new Car());
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Passenger getDriver() {
        return driver;
    }

    public void setDriver(Passenger driver) {
        this.driver = driver;
    }
}
