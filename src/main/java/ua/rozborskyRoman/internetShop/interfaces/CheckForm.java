package ua.rozborskyRoman.internetShop.interfaces;

/**
 * Created by roman on 31.07.2016.
 */
public interface CheckForm {
    boolean checkLogin(String login);
    boolean checkEqualsPasswords(String password, String confirmPassword);
}
