package ua.rozborskyRoman.internetShop.interfaces;

import java.util.List;

/**
 * Created by roman on 29.08.2016.
 */
public interface Goods {

    int getId();

    void setId(int id);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    float getPrice();

    void setPrice(float price);

    String getCategory();

    void setCategory(String category);
}
