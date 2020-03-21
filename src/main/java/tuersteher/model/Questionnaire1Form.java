package tuersteher.model;

/**
 * @author Thure Nebendahl on 21.03.20
 */
public class Questionnaire1Form {
    private String firstname;
    private String lastname;
    private String email;
    private String street;
    private String postcode;
    private String city;
    private String country;
    private String license_plate;
    private String pass_nr;
    private String pass_expiry_date;

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
