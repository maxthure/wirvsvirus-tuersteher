package tuersteher.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Entity
public class Car {
    @Id
    @NotNull
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
