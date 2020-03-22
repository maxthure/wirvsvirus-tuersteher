package tuersteher.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuersteher.model.*;
import tuersteher.repository.CarRepository;
import tuersteher.repository.PassengerRepository;
import tuersteher.repository.PassengerTripRepository;
import tuersteher.repository.TripRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Transactional
@Service
public class TripService {

    private final TripRepository tripRepository;
    private final CarRepository carRepository;
    private final PassengerRepository passengerRepository;
    private final PassengerTripRepository passengerTripRepository;

    public TripService(TripRepository tripRepository, CarRepository carRepository,
                       PassengerRepository passengerRepository, PassengerTripRepository passengerTripRepository) {
        this.tripRepository = tripRepository;
        this.carRepository = carRepository;
        this.passengerRepository = passengerRepository;
        this.passengerTripRepository = passengerTripRepository;
    }

    public Trip getTripByCar(String id) {
        Optional<Car> car = carRepository.findById(id);
        Optional<Trip> foundTrip = car.flatMap(tripRepository::getFirstTripByCarOrderByDateDesc);
        return foundTrip.orElseThrow(() -> new RuntimeException("Could not find trip!"));
    }

    public List<Trip> getAllTrips() {
        return StreamSupport
                .stream(tripRepository.findAll().spliterator(), true)
                .collect(Collectors.toUnmodifiableList());
    }

    public Trip createTrip(@Valid Trip trip) {
        Trip toSave = new Trip();
        toSave.setCar(getOrSaveCar(trip.getCar()));
        toSave.setPassengers(trip.getPassengers()
                .stream()
                .map(this::getOrSavePassengerTrip)
                .collect(Collectors.toList()));

        toSave.setReason(trip.getReason());
        toSave.setDestination(trip.getDestination());
        toSave.setOk(true);

        return tripRepository.save(toSave);
    }

    public boolean isTripOk(Trip trip) {
        if (!trip.isOk()) {
            System.out.println("!");
            return false;
        }
        for (PassengerTrip pt : trip.getPassengers()) {
            Passenger passenger = pt.getPassenger();
            //TODO remove println
            if(passenger.getVisaExpirationDate() != null){
                LocalDate date = LocalDate.now();
                if (passenger.getPassExpirationDate().isBefore(date.plusMonths(3))){
                    return false;
                }
            }
            if(passenger.getVisitedHighRiskCountry()){
                return false;
            }
        }
        return true;
    }

    private Car getOrSaveCar(Car provided) {
        provided.setId(provided.getLicense_plate());
        Car car = carRepository.findById(provided.getId()).orElse(provided);
        return carRepository.save(car);
    }

    private PassengerTrip getOrSavePassengerTrip(PassengerTrip passengerTrip) {
        Passenger passenger = passengerRepository.save(passengerTrip.getPassenger());
        passengerTrip.setPassenger(passenger);
        passengerTrip.setTripStatus(TripStatus.TENTATIVE);
        return passengerTripRepository.save(passengerTrip);
    }
}
