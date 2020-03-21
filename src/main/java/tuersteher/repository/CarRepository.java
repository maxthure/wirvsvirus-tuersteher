package tuersteher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tuersteher.model.Car;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Repository
public interface CarRepository extends CrudRepository<Car, String> {
}
