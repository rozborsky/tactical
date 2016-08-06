package ua.rozborskyRoman.internetShop.classes.cart;

/**
 * Created by roman on 06.08.2016.
 */
public class GoodsInCart {

    private String name;

    private int number;

    private float prise;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
