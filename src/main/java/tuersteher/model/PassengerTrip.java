package tuersteher.model;

import javax.persistence.*;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Entity
public class PassengerTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Passenger passenger;
    private TripStatus tripStatus;

    public Passenger getPassenger() {
        return passenger;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }
}
