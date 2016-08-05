package ua.rozborskyRoman.internetShop.interfaces;

import ua.rozborskyRoman.internetShop.classes.Buyer;
import ua.rozborskyRoman.internetShop.classes.GoodsCategory;

import java.util.List;
import java.util.Map;

/**
 * Created by roman on 29.07.2016.
 */
public interface DAO {

    void addBuyer(Buyer buyer);

    boolean isExistLogin(String login);

    boolean checkPassword(String login, String Password);

    List<GoodsCategory> takeListGoods(String tableName);
}
