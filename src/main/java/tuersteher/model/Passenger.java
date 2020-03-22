package tuersteher.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    private Instant birthday;
    @NotNull
    @NotEmpty
    private String passNumber;
    @NotNull
    private Instant passExpirationDate;
    @NotNull
    @NotEmpty
    private String streetAndNr;
    @NotNull
    private String areaCode;
    @NotEmpty
    @NotNull
    private String city;
    @NotEmpty
    @NotNull
    private String country;
    @NotEmpty
    @NotNull
    private String email;
    @NotEmpty
    @NotNull
    private String mobileNumber;

    //TODO Annotationen (sind beide jedoch optional)
    private String visaNumber;

    private Instant visaExpirationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public Instant getPassExpirationDate() {
        return passExpirationDate;
    }

    public void setPassExpirationDate(Instant passExpirationDate) {
        this.passExpirationDate = passExpirationDate;
    }

    public String getStreetAndNr() {
        return streetAndNr;
    }

    public void setStreetAndNr(String streetAndNr) {
        this.streetAndNr = streetAndNr;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public Instant getVisaExpirationDate() {
        return visaExpirationDate;
    }

    public void setVisaExpirationDate(Instant visaExpirationDate) {
        this.visaExpirationDate = visaExpirationDate;
    }
}
