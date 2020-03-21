package tuersteher.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    private Car car;

    @NotNull
    @NotEmpty
    @OneToMany(targetEntity = PassengerTrip.class, fetch = FetchType.EAGER)
    private List<PassengerTrip> passengers;

    @NotNull
    @NotEmpty
    private String reason;

    @NotNull
    @NotEmpty
    private String destination;

    @Transient
    private int numberOfPassengers;

    private Instant date = Instant.now();

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    private boolean isOk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<PassengerTrip> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerTrip> passengers) {
        this.passengers = passengers;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
