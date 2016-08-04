package ua.rozborskyRoman.internetShop.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by roman on 29.07.2016.
 */
@Component
public class SQLiteDbManager implements DAO {

    private DataSource dataSource;

   private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("dataSourceSQLite")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addBuyer(Buyer buyer) {
        String query = "INSERT INTO buyer (name, surname, eMail, login, address, phone, password) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(query, new Object []{buyer.getName(), buyer.getSurname(), buyer.geteMail(), buyer.getLogin(),
                buyer.getAddress(), buyer.getPhone(), buyer.getPassword()});
    }

    @Override
    public boolean isExistLogin(String login) {
        try {
            jdbcTemplate.queryForMap("SELECT * FROM buyer WHERE login = '" + login + "'");
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkPassword(String login, String password) {
        String passwordInDb = jdbcTemplate.queryForObject("SELECT password FROM buyer WHERE login = ?",
                new Object[]{login}, String.class);
        if(passwordInDb.equals(password)){
            return true;
        }
        return false;
    }
}
