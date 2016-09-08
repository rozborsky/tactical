package ua.rozborskyRoman.internetShop.classes.goods;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.classes.TacticException;
import ua.rozborskyRoman.internetShop.interfaces.Category;
import ua.rozborskyRoman.internetShop.interfaces.GoodsCategoriesManager;
import ua.rozborskyRoman.internetShop.server.HibernateUtil;

import java.util.List;

/**
 * Created by roman on 07.09.2016.
 */

@Component
public class GoodsCategoriesManagerHibernate implements GoodsCategoriesManager{
    @Override
    public void addCategory(Category category) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new TacticException();
        } finally {
            if ((session != null) && (session.isOpen())){
                session.close();
            }
        }
    }

    @Override
    public void deleteCategory(Category category) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new TacticException();
        } finally {
            if ((session != null) && (session.isOpen())){
                session.close();
            }
        }
    }

    @Override
    public Category getCategory(int id) {
        Category category = null;
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            category = (Category) session.load(Category.class, id);
        } catch (Exception e) {
            throw new TacticException();
        } finally {
            if ((session != null) && (session.isOpen())){
                session.close();
            }
        }
        return category;
    }

    @Override
    public List<Category> getListCategories() {

        List<Category> categories = null;
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            categories = session.createCriteria(Category.class).list();
        } catch (Exception e) {
            throw new TacticException();
        } finally {
            if ((session != null) && (session.isOpen())){
                session.close();
            }
        }
        return categories;
    }
}
