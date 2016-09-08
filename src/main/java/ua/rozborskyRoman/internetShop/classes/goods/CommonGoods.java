package ua.rozborskyRoman.internetShop.classes.goods;

import ua.rozborskyRoman.internetShop.interfaces.Goods;

import java.util.List;

/**
 * Created by roman on 06.08.2016.
 */
public class CommonGoods implements Goods {

    private int id;

    private List<String> images;

    private String title;

    private String description;

    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }



}
