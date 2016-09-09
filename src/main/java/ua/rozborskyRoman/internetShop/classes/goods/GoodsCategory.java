package ua.rozborskyRoman.internetShop.classes.goods;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.Category;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by roman on 05.08.2016.
 */
@Entity
@Table(name = "goods_category")
@Component
public class GoodsCategory implements Category{

    public GoodsCategory(){

    }
    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    @Length(max = 10000)
    private String description;

    @OneToMany(mappedBy = "goodsCategory", cascade = CascadeType.ALL)
    private List<CommonGoods> products;

    public List<CommonGoods> getProducts() {
        return products;
    }

    public void setProducts(List<CommonGoods> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}