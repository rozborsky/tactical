package ua.rozborskyRoman.internetShop.interfaces;

import ua.rozborskyRoman.internetShop.classes.Buyer;

/**
 * Created by roman on 29.07.2016.
 */
public interface DAO {

    void addBuyer(Buyer buyer);

    boolean isExistLogin(String login);

    boolean checkPassword(String login, String Password);
}
