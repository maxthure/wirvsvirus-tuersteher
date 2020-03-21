package tuersteher.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuersteher.model.Car;
import tuersteher.model.Passenger;
import tuersteher.model.Trip;
import tuersteher.repository.CarRepository;
import tuersteher.repository.PassengerRepository;
import tuersteher.repository.TripRepository;

import javax.validation.Valid;
import java.util.List;
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

    public TripService(TripRepository tripRepository, CarRepository carRepository, PassengerRepository passengerRepository) {
        this.tripRepository = tripRepository;
        this.carRepository = carRepository;
        this.passengerRepository = passengerRepository;
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
                .map(this::getOrSavePassenger)
                .collect(Collectors.toList()));

        toSave.setOk(true);

        return tripRepository.save(toSave);
    }

    private Car getOrSaveCar(Car provided) {
        return carRepository.save(provided);
    }

    private Passenger getOrSavePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
