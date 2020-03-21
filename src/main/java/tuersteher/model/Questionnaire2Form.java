package tuersteher.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thure Nebendahl on 21.03.20
 */
public class Questionnaire2Form {
    private List<Passenger> passengerList;

    public Questionnaire2Form(){
        passengerList = new ArrayList<>();
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
}
