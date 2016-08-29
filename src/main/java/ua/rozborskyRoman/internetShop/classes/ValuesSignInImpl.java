package ua.rozborskyRoman.internetShop.classes;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.DAO;
import ua.rozborskyRoman.internetShop.interfaces.ValuesSignIn;

/**
 * Created by roman on 01.08.2016.
 */
@Component
public class ValuesSignInImpl implements ValuesSignIn{

    @NotEmpty(message = "insert login")
    private String login;

    @NotEmpty(message = "insert password")
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
