package ua.rozborskyRoman.internetShop.interfaces;

import ua.rozborskyRoman.internetShop.classes.goods.CommonGoods;
import ua.rozborskyRoman.internetShop.classes.goods.GoodsCategory;

import java.util.List;

/**
 * Created by roman on 29.07.2016.
 */
public interface DAO {

    boolean isExistLogin(String login);

    boolean checkPassword(String login, String Password);

    String takeDescription(String table, String division);

    List<GoodsCategory> takeListSubdivision(String tableName);

    int getBuyerIg(String login);

    String getBuyerName(int id);

    List<CommonGoods> takeListGoods(String tableName);

    CommonGoods takeGoods(String tableName, String goods);
}
