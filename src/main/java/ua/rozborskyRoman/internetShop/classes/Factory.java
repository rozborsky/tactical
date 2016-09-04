package ua.rozborskyRoman.internetShop.classes;

import ua.rozborskyRoman.internetShop.classes.model.SaveBuyerImpl;
import ua.rozborskyRoman.internetShop.interfaces.Person;
import ua.rozborskyRoman.internetShop.interfaces.SaveBuyer;

/**
 * Created by roman on 03.09.2016.
 */
public class Factory {
    public  static Factory instance = new Factory();

    public SaveBuyer saveBuyer;

    private Factory() {

    }

    public static Factory getInstance() {
        return Factory.instance;
    }

    public SaveBuyer getBuyer() {
        if (saveBuyer == null) saveBuyer = new SaveBuyerImpl();
        return saveBuyer;
    }
}
