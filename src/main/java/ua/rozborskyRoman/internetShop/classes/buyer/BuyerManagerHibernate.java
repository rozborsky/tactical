package ua.rozborskyRoman.internetShop.classes.buyer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.interfaces.BuyerManager;
import ua.rozborskyRoman.internetShop.server.HibernateUtil;

/**
 * Created by roman on 04.09.2016.
 */
@Component
public class BuyerManagerHibernate implements BuyerManager {
    static SessionFactory sessionFactory = null;
    static{
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void registerBuyer(Buyer buyer) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(buyer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen()))session.close();
        }
    }

    @Override
    public Buyer getBuyer(int id) {
        Buyer buyer = null;
        Session session = null;
        try{
            session = sessionFactory.openSession();
            buyer = (Buyer) session.load(Buyer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())){
                session.close();
            }
        }
        return buyer;
    }
}
