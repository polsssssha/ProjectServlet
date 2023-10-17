package com.devcolibri.app.config;

import com.devcolibri.app.model.UserModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.sql.Driver;
import java.sql.DriverManager;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {}

    public synchronized static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            try {
                final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure().build();
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}