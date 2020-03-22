package tuersteher.service;

import org.springframework.stereotype.Service;
import tuersteher.model.ControlForm;
import tuersteher.model.PassengerTrip;
import tuersteher.model.Trip;
import tuersteher.model.TripStatus;
import tuersteher.repository.PassengerTripRepository;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Service
public class TripControlService {

    private final TripService tripService;
    private final PassengerTripRepository passengerTripRepository;

    public TripControlService(TripService tripService, PassengerTripRepository passengerTripRepository) {
        this.tripService = tripService;
        this.passengerTripRepository = passengerTripRepository;
    }

    public ControlForm populateForm(ControlForm form) {
        Trip trip = tripService.getTripByCar(form.getPlate());
        form.setTrip(trip);
        return form;
    }

    public ControlForm updateFormPassengerStatus(ControlForm form, Long passengerTripId, TripStatus tripStatus) {
        PassengerTrip passengerTrip = passengerTripRepository.findById(passengerTripId).orElseThrow();
        passengerTrip.setTripStatus(tripStatus);
        passengerTripRepository.save(passengerTrip);
        Trip trip = tripService.getTripByCar(form.getPlate());
        form.setTrip(trip);
        return form;
    }

    public ControlForm updateFormPassengerStatusForAll(ControlForm form, TripStatus tripStatus) {
        passengerTripRepository.saveAll(
                form.getTrip().getPassengers()
                        .stream()
                        .map(t -> passengerTripRepository.findById(t.getId()))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .map(t -> {
                            t.setTripStatus(tripStatus);
                            return passengerTripRepository.save(t);
                        })
                        .collect(Collectors.toList())
        );

        Trip trip = tripService.getTripByCar(form.getPlate());
        form.setTrip(trip);
        return form;
    }
}
