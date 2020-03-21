package tuersteher.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuersteher.model.Passenger;
import tuersteher.model.QuestionnaireForm;
import tuersteher.model.Trip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Thure Nebendahl on 21.03.20
 */
@Transactional
@Service
public class QuestionnaireService {
    HashSet<String> visaCountries;

    public QuestionnaireService() {
        visaCountries = new HashSet<>();
    }

    public void processQuestionnaire1(QuestionnaireForm form) {
        Passenger passenger = form.getDriver();
        //TODO remove println
        System.out.println(passenger.getCountry());
        Trip trip = form.getTrip();
    }

    public void processQuestionnaire2(QuestionnaireForm form) {
        List<Passenger> passengers = form.getPassengerList();
    }

    public List<Passenger> visaPassengers(List<Passenger> passengers) {
        List<Passenger> temp = new ArrayList<>();
        for (Passenger passenger :
                passengers) {
            if (visaCountries.contains(passenger.getCountry())) {
                temp.add(passenger);
            }
        }
        return temp;
    }
}
