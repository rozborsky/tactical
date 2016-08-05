package ua.rozborskyRoman.internetShop.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
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

    @Override
    public List<GoodsCategory> takeListGoods(String tableName) {
        final String sql = "SELECT * FROM " + tableName;

        List<GoodsCategory> listCategoryOfGoods = jdbcTemplate.query(sql, new RowMapper<GoodsCategory>() {

            @Override
            public GoodsCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
                GoodsCategory goodsCategory = new GoodsCategory();
                goodsCategory.setName(rs.getString("name"));
                goodsCategory.setImage(rs.getString("image"));
                return goodsCategory;
            }

        });
        return listCategoryOfGoods;
    }
}
