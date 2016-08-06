package ua.rozborskyRoman.internetShop.classes.cart;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman on 06.08.2016.
 */

@Component
public class Order {

    private List<GoodsInCart> orderedGoods = new ArrayList<>();

    public List<GoodsInCart> getOrder () {
        return orderedGoods;
    }

    public void addGoods(GoodsInCart goods) {
        orderedGoods.add(goods);
    }

    public float totalPrise() {
        float prise = 0;

        for (int i = 0; i < orderedGoods.size(); i++) {
            prise += orderedGoods.get(i).getPrise() * orderedGoods.get(i).getNumber();
        }
        return prise;
    }
}
