package ua.rozborskyRoman.internetShop.interfaces;

/**
 * Created by roman on 29.08.2016.
 */
public interface BuyerValidator {
    void setConfirmPassword(String confirmPassword);

    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);

    String geteMail();

    void seteMail(String eMail);

    String getAddress();

    void setAddress(String address);

    String getPhone();

    void setPhone(String phone);

    String getPassword();

    void setPassword(String password);

    String getLogin();

    void setLogin(String login);
}
