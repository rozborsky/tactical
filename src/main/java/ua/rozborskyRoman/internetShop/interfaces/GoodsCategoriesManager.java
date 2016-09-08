package ua.rozborskyRoman.internetShop.interfaces;

import java.util.List;

/**
 * Created by roman on 07.09.2016.
 */
public interface GoodsCategoriesManager {

    void addCategory(Category category);

    void deleteCategory(Category category);

    Category getCategory(int id);

    List<Category> getListCategories();
}
