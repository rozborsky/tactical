package ua.rozborskyRoman.internetShop.classes;

import java.util.Map;

/**
 * Created by roman on 05.08.2016.
 */
public class GoodsCategory {

    private String name;

    private String image;

    //private Map <String, String> subcategory;


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

//    public Map<String, String> getSubcategory() {
//        return subcategory;
//    }
//
//    public void setSubcategory(Map<String, String> subcategory) {
//        this.subcategory = subcategory;
//    }
}