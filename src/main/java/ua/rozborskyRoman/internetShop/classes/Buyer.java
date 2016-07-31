package ua.rozborskyRoman.internetShop.classes;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by roman on 30.07.2016.
 */
public class Buyer {
    @NotEmpty(message = "enter name")
    @Size(min=2, max = 20, message = "name must be from 2 to 20 symbols")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only characters are allowed")
    private String name;

    @NotEmpty(message = "enter surname")
    @Size(min=2, max = 20, message = "surname must be from 2 to 20 symbols")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only characters are allowed")
    private String surname;

    @NotEmpty(message = "enter e-mail")
    @Email(message = "e-mail is not correct")
    private String eMail;

    @NotEmpty(message = "enter adress")
    @Size(min=10, max = 50, message = "adress must be from 10 to 50 symbols")
    private String address;

    @NotEmpty(message = "enter phone number")
    @Size(min=10, max = 20, message = "phone number must be from 10 to 20 symbols")
    @Pattern(regexp = "^[\\d | \\s | _ | \\- | ( | )]*$", message = "not valid phone number")
    private String phone;

    @NotEmpty(message = "enter password")
    @Size(min=6, max = 15, message = "password must be from 6 to 15 symbols")
    private String password;

    @NotEmpty(message = "passwords are not aquals")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    private String confirmPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}