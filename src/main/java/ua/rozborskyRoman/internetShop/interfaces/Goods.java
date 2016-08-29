package ua.rozborskyRoman.internetShop.interfaces;

import java.util.List;

/**
 * Created by roman on 29.08.2016.
 */
public interface Goods {

    int getId();

    void setId(int id);

    List<String> getImages();

    void setImages(List<String> images);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    float getPrice();

    void setPrice(float price);
}
