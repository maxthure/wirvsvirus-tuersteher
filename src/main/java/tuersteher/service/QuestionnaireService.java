package tuersteher.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuersteher.model.Passenger;
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
    HashSet<String> visaCountries;

    public QuestionnaireService() {
        visaCountries = new HashSet<>();
        prepareVisaCountries(visaCountries);
    }

    public void prepareVisaCountries(HashSet<String> visaCountries) {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("src/main/resources/static/visaCountries.txt"));
            String line = reader.readLine();
            while (line != null){
                visaCountries.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
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
