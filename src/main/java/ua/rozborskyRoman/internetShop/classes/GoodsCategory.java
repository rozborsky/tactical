package ua.rozborskyRoman.internetShop.classes;

import ua.rozborskyRoman.internetShop.interfaces.Category;

/**
 * Created by roman on 05.08.2016.
 */
public class GoodsCategory implements Category{

    private int id;

    private String name;

    private String image;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}