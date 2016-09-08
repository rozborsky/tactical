package ua.rozborskyRoman.internetShop.classes.model;

import ua.rozborskyRoman.internetShop.classes.goods.CommonGoods;
import ua.rozborskyRoman.internetShop.classes.goods.GoodsCategory;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

import java.util.List;

/**
 * Created by roman on 06.09.2016.
 */

public class HibernateDbManager implements DAO {

    @Override
    public boolean isExistLogin(String login) {
        return false;
    }

    @Override
    public boolean checkPassword(String login, String Password) {
        return false;
    }

    @Override
    public String takeDescription(String table, String division) {
        return null;
    }

    @Override
    public List<GoodsCategory> takeListSubdivision(String tableName) {
        return null;
    }

    @Override
    public int getBuyerIg(String login) {
        return 0;
    }

    @Override
    public String getBuyerName(int id) {
        return null;
    }

    @Override
    public List<CommonGoods> takeListGoods(String tableName) {
        return null;
    }

     @Override
    public CommonGoods takeGoods(String tableName, String goods) {
        return null;
    }
}
