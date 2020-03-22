package tuersteher.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuersteher.model.Passenger;
import tuersteher.model.PassengerTrip;
import tuersteher.model.QuestionnaireForm;
import tuersteher.model.Trip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Thure Nebendahl on 21.03.20
 */
@Transactional
@Service
public class QuestionnaireService {

    private TripService tripService;
    private HashSet<String> visaCountries;


    public QuestionnaireService(TripService tripService) {
        visaCountries = new HashSet<>();
        prepareVisaCountries(visaCountries);
        this.tripService = tripService;
    }

    public void prepareVisaCountries(HashSet<String> visaCountries) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/static/visaCountries.txt"));
            String line = reader.readLine();
            while (line != null) {
                visaCountries.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processQuestionnaire1(QuestionnaireForm form) {
        Passenger passenger = form.getDriver();
        Trip trip = form.getTrip();
        trip.addPassenger(passenger);
    }

    public void processQuestionnaire2(QuestionnaireForm form) {
        List<Passenger> passengers = form.getPassengerList();
        Trip trip = form.getTrip();
        for (Passenger passenger: passengers) {
            trip.addPassenger(passenger);
        }
    }

    public void processQuestionnaire3(QuestionnaireForm form) {

    }

    public void processQuestionnaireEnd(QuestionnaireForm form){
        Trip trip = tripService.createTrip(form.getTrip());
    }

    public List<Passenger> visaPassengers(List<PassengerTrip> passengers) {
        List<Passenger> temp = new ArrayList<>();
        for (PassengerTrip passengerTrip : passengers) {
            if (visaCountries.contains(passengerTrip.getPassenger().getCountry())) {
                temp.add(passengerTrip.getPassenger());
            }
        }
        return temp;
    }
}
