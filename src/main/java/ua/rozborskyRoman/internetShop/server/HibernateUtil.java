package ua.rozborskyRoman.internetShop.server;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private  static SessionFactory sessionFactory;

    private HibernateUtil() {}
    static{
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}