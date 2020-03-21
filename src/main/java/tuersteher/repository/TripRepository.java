package tuersteher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tuersteher.model.Car;
import tuersteher.model.Trip;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
    Optional<Trip> getTripById(Long id);
    List<Trip> getTripsByCar(Car car);
    Optional<Trip> getFirstTripByCarOrderByDateDesc(Car car);
}
