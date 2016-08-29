package ua.rozborskyRoman.internetShop.classes.cart;

import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.GoodsInCart;

/**
 * Created by roman on 06.08.2016.
 */
@Component
public class GoodsInCartImpl implements GoodsInCart{

    private String title;

    private int number;

    private double prise;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public double getPrise() {
        return prise;
    }
}
