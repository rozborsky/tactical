package ua.rozborskyRoman.internetShop.classes.goods;

import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.Goods;

import javax.persistence.*;
import java.util.List;

/**
 * Created by roman on 06.08.2016.
 */
@Entity
@Table(name = "goods")
@Component
public class CommonGoods implements Goods {

    public CommonGoods(){

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "category")
    private String category;

    @ManyToOne(optional = false)
    @JoinColumn(name="categoryId")
    private GoodsCategory goodsCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    }