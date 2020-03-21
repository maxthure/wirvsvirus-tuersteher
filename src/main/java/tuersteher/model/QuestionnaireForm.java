package tuersteher.model;

/**
 * @author Thure Nebendahl on 21.03.20
 */
public class QuestionnaireForm {
    private String firstname;
    private String lastname;
    private String date_of_birth;
    private String email;
    private String mobile;
    private String street;
    private String postcode;
    private String city;
    private String country;
    private String license_plate;
    private String pass_nr;
    private String pass_expiry_date;
    private String reason_for_traveling;
    private String travel_destination;
    private int number_of_passengers;
    private Car car = new Car();

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public String getReason_for_traveling() {
        return reason_for_traveling;
    }

    public void setReason_for_traveling(String reason_for_traveling) {
        this.reason_for_traveling = reason_for_traveling;
    }

    public String getTravel_destination() {
        return travel_destination;
    }

    public void setTravel_destination(String travel_destination) {
        this.travel_destination = travel_destination;
    }

    public int getNumber_of_passengers() {
        return number_of_passengers;
    }

    public void setNumber_of_passengers(int number_of_passengers) {
        this.number_of_passengers = number_of_passengers;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setLicense_plate(String license_plate) { this.license_plate = license_plate; }

    public String getLicense_plate() {
        return this.license_plate;
    }

    public void setPass_nr(String pass_nr) { this.pass_nr = pass_nr; }

    public String getPass_nr() {
        return this.pass_nr;
    }

    public void setPass_expiry_date(String pass_expiry_date) { this.pass_expiry_date = pass_expiry_date; }

    public String getPass_expiry_date() {
        return this.pass_expiry_date;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }
}
