package ua.rozborskyRoman.internetShop.interfaces;

/**
 * Created by roman on 29.08.2016.
 */
public interface Category {
    String getDescription();

    void setDescription(String description);

    String getName();

    void setName(String name);

    String getImage();

    void setImage(String image);

    int getId();

    void setId(int id);
}
