package tuersteher.service;

import org.springframework.stereotype.Service;
import tuersteher.model.ControlForm;
import tuersteher.model.Trip;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Service
public class TripControlService {

    private final TripService tripService;

    public TripControlService(TripService tripService) {
        this.tripService = tripService;
    }

    public ControlForm populateForm(ControlForm form) {
        Trip trip = tripService.getTripByCar(form.getPlate());
        form.setTrip(trip);
        return form;
    }
}
