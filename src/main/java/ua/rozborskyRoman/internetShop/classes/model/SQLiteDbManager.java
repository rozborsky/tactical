package ua.rozborskyRoman.internetShop.classes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.classes.Buyer;
import ua.rozborskyRoman.internetShop.classes.Goods;
import ua.rozborskyRoman.internetShop.classes.GoodsCategory;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
        jdbcTemplate.update(query, new Object[]{buyer.getName(), buyer.getSurname(), buyer.geteMail(), buyer.getLogin(),
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
        if (passwordInDb.equals(password)) {

            return true;
        }

        return false;
    }

    @Override
    public List<GoodsCategory> takeListCategory(String tableName) {
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
        for (int i = 0; i < listCategoryOfGoods.size(); i++) {
            listCategoryOfGoods.get(i).getImage();
        }

        return listCategoryOfGoods;
    }

    @Override
    public String takeDescription(String table, String category) {
        final String sql = "SELECT description FROM " + table + " WHERE name = ?";

        String description = jdbcTemplate.queryForObject(sql, new Object[] {category}, String.class);

        return description;
    }

    @Override
    public List<GoodsCategory> takeListSubdivision(String tableName) {
        final String sql = "SELECT * FROM " + tableName;


        List<GoodsCategory> listCategoryOfGoods = jdbcTemplate.query(sql, new RowMapper<GoodsCategory>() {

            @Override
            public GoodsCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
                GoodsCategory goodsCategory = new GoodsCategory();
                goodsCategory.setName(rs.getString("name"));
                goodsCategory.setImage(rs.getString("image"));
                goodsCategory.setDescription(rs.getString("description"));
                return goodsCategory;
            }

        });
        for (int i = 0; i < listCategoryOfGoods.size(); i++) {
            listCategoryOfGoods.get(i).getImage();
        }

        return listCategoryOfGoods;
    }

    @Override
    public int getBuyerIg(String login) {
        return jdbcTemplate.queryForObject("SELECT rowid FROM buyer WHERE login = ?",
                new Object[]{login}, Integer.class);
    }

    @Override
    public String getBuyerName(int id) {
        return jdbcTemplate.queryForObject("SELECT name FROM buyer WHERE rowid = ?",
                new Object[]{id}, String.class);
    }


    @Override
    public List<Goods> takeListGoods(String tableName) {
        final String sql = "SELECT * FROM " + tableName;
        List<Goods> listOfGoods = jdbcTemplate.query(sql, new RowMapper<Goods>() {

            @Override
            public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
                Goods goods = new Goods();
                goods.setTitle(rs.getString("title"));
                goods.setDescription(rs.getString("description"));
                goods.setPrice(rs.getFloat("prise"));
                return goods;
            }
        });
        return listOfGoods;
    }

    @Override
    public Goods takeGoods(String tableName, String goods) {
        System.out.println("SELECT * FROM " + tableName + " WHERE title = " + goods);
        String sql = "SELECT * FROM " + tableName + " WHERE title = ?";
        Goods result = (Goods)jdbcTemplate.queryForObject(sql, new Object[] {goods}, new RowMapper<Goods>() {
            @Override
            public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
                Goods goods = new Goods();
                goods.setTitle(rs.getString("title"));
                goods.setDescription(rs.getString("description"));
                goods.setPrice(rs.getFloat("prise"));
                return goods;
            }
        });

        return result;
    }
}
