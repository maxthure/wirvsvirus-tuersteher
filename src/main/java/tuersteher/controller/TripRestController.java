package tuersteher.controller;

import org.springframework.web.bind.annotation.*;
import tuersteher.model.Trip;
import tuersteher.service.TripService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Robert Rabe on 21.03.20.
 */
@RestController
public class TripRestController {

    private final TripService tripService;

    public TripRestController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public List<Trip> getTrips() {
        return tripService.getAllTrips();
    }

    @PostMapping("/trip")
    public Trip createTrip(@RequestBody @Valid Trip trip) {
        return this.tripService.createTrip(trip);
    }

    @GetMapping("/trip/car/{id}")
    public Trip getTripByCar(@PathVariable String id) {
        return this.tripService.getTripByCar(id);
    }
}
