package ua.rozborskyRoman.internetShop.classes;


import org.springframework.stereotype.Component;

import javax.persistence.*;
/**
 * Created by roman on 04.09.2016.
 */
@Entity
@Table(name = "buyer")
@Component
public class Buyer {

    public void setValues(BuyerValidatorImpl buyerValidator){
        this.name = buyerValidator.getName();
        this.surname = buyerValidator.getSurname();
        this.eMail = buyerValidator.geteMail();
        this.address = buyerValidator.getAddress();
        this.phone = buyerValidator.getPhone();
        this.password = buyerValidator.getPassword();
        this.login = buyerValidator.getLogin();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "eMail")
    private String eMail;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "login")
    private String login;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String geteMail() {
        return eMail;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
