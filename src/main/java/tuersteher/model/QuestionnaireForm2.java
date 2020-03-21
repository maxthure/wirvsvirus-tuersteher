package tuersteher.model;

/**
 * @author Thure Nebendahl on 21.03.20
 */
public class QuestionnaireForm2 {
    private String firstname;
    private String lastname;
    private String email;
    private String street;
    private String postcode;
    private String city;
    private String country;
    private String gender;
    private String license_plate;
    private String pass_visa_nr;
    private String pass_visa_expiry_date;

    public void setGender(String gender) { this.gender = gender; }

    public String getGender() {
        return this.gender;
    }

    public void setLicense_plate(String license_plate) { this.license_plate = license_plate; }

    public String getLicense_plate() {
        return this.license_plate;
    }

    public void setPass_visa_nr(String pass_visa_nr) { this.pass_visa_nr = pass_visa_nr; }

    public String getPass_visa_nr() {
        return this.pass_visa_nr;
    }

    public void setPass_visa_expiry_date(String pass_visa_expiry_date) { this.pass_visa_expiry_date = pass_visa_expiry_date; }

    public String getPass_visa_expiry_date() {
        return this.pass_visa_expiry_date;
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
