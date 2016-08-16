package ua.rozborskyRoman.internetShop.classes.cart;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
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

        for (int i = 0; i < getOrder().size(); i++) {
            if (getOrder().get(i).getTitle().equals(goods.getTitle())) {
                int number = getOrder().get(i).getNumber();
                getOrder().get(i).setNumber(++number);
                return;
            }
        }
        orderedGoods.add(goods);
    }

    public void removeGoods(String goods) {
        for (Iterator<GoodsInCart> iter = getOrder().listIterator(); iter.hasNext(); ) {
            if (iter.next().getTitle().equals(goods)) {
                iter.remove();
            }
        }
    }

    public double totalPrise() {
        double prise = 0;

        for (int i = 0; i < orderedGoods.size(); i++) {
            prise += orderedGoods.get(i).getPrise() * orderedGoods.get(i).getNumber();
        }
        return prise;
    }
}
