package ua.rozborskyRoman.internetShop.classes;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ua.rozborskyRoman.internetShop.classes.Buyer;
import ua.rozborskyRoman.internetShop.interfaces.SaveBuyer;
import ua.rozborskyRoman.internetShop.server.HibernateUtil;

/**
 * Created by roman on 04.09.2016.
 */
@Component
public class SaveBuyerImpl implements SaveBuyer{
    @Override
    public void registerBuyer(Buyer buyer) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(buyer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen()))session.close();
        }
    }
}
