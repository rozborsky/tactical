package ua.rozborskyRoman.internetShop.interfaces;

/**
 * Created by roman on 29.08.2016.
 */
public interface GoodsInCart {
    String getTitle();

    void setTitle(String title);

    int getNumber();

    void setNumber(int number);

    void setPrise(double prise);

    double getPrise();
}
