package ua.rozborskyRoman.internetShop.classes.cart;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;

/**
 * Created by roman on 06.08.2016.
 */
@Component
public class GoodsInCart {

    private String title;

    private int number;

    private float prise;

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

    public void setPrise(float prise) {
        this.prise = prise;
    }

    public float getPrise() {
        return prise;
    }
}
