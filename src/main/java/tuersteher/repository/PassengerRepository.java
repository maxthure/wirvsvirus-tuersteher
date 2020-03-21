package tuersteher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tuersteher.model.Passenger;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {
}
