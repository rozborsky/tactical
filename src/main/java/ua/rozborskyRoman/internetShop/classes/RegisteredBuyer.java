package ua.rozborskyRoman.internetShop.classes;

import org.springframework.stereotype.Component;

/**
 * Created by roman on 08.08.2016.
 */
@Component
public class RegisteredBuyer {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
