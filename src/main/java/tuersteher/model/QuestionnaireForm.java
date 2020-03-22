package tuersteher.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thure Nebendahl on 21.03.20
 */
public class QuestionnaireForm {
    private Trip trip;
    private Passenger driver;
    private int visaPassengersCount;
    private List<Passenger> passengerList;
    private List<Passenger> visaPassengers;
    private List<String> highRiskCountries;

    public QuestionnaireForm(){
        trip = new Trip();
        driver = new Passenger();
        trip.setCar(new Car());
        passengerList = new ArrayList<>();
        visaPassengers = new ArrayList<>();
        highRiskCountries = new ArrayList<>();
    }

    public List<String> getHighRiskCountries() {
        return highRiskCountries;
    }

    public void setHighRiskCountries(List<String> highRiskCountries) {
        this.highRiskCountries = highRiskCountries;
    }

    public List<Passenger> getVisaPassengers() {
        return visaPassengers;
    }

    public void setVisaPassengers(List<Passenger> visaPassengers) {
        this.visaPassengers = visaPassengers;
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

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public int getVisaPassengersCount() {
        if (visaPassengers != null){
            visaPassengersCount = visaPassengers.size();
        } else {
            visaPassengersCount = 0;
        }
        return visaPassengersCount;
    }

    public void setVisaPassengersCount(int visaPassengersCount) {
        this.visaPassengersCount = visaPassengersCount;
    }
}
