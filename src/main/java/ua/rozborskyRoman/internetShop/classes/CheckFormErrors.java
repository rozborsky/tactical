package ua.rozborskyRoman.internetShop.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.classes.model.SQLiteDbManager;
import ua.rozborskyRoman.internetShop.interfaces.CheckForm;

/**
 * Created by roman on 01.08.2016.
 */
@Component
public class CheckFormErrors  implements CheckForm{

    @Autowired
    SQLiteDbManager sqLiteDbManager;

    @Override
    public boolean checkLogin(String login) {
        return sqLiteDbManager.isExistLogin(login);
    }

    @Override
    public boolean checkEqualsPasswords(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
