package ua.rozborskyRoman.internetShop.interfaces;

import ua.rozborskyRoman.internetShop.classes.Buyer;
import ua.rozborskyRoman.internetShop.classes.Goods;
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

    String takeDescription(String table, String division);

    List<GoodsCategory> takeListSubdivision(String tableName);

    int getBuyerIg(String login);

    String getBuyerName(int id);

    List<Goods> takeListGoods(String tableName);

    List<GoodsCategory> takeListCategory(String tableName);

    Goods takeGoods(String tableName, String goods);
}
