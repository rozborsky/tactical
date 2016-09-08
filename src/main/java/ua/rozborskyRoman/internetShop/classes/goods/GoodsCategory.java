package ua.rozborskyRoman.internetShop.classes.goods;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.Category;

import javax.persistence.*;

/**
 * Created by roman on 05.08.2016.
 */
@Entity
@Table(name = "goodsCategory")
@Component
public class GoodsCategory implements Category{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    @Length(max = 10000)
    private String description;

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