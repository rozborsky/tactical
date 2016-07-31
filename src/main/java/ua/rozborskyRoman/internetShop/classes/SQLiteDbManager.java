package ua.rozborskyRoman.internetShop.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

import javax.sql.DataSource;

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
        String sql = "INSERT INTO buyer (name, surname, eMail, address, phone, password) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object []{buyer.getName(),buyer.getSurname(),buyer.geteMail(),buyer.getAddress(),
                buyer.getPhone(),buyer.getPassword()});
    }

}
