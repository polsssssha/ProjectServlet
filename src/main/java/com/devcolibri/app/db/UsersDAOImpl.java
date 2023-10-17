package com.devcolibri.app.db;

import com.devcolibri.app.config.HibernateSessionFactory;
import com.devcolibri.app.model.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    private final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    @Override
    public UserModel get(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(UserModel.class, id);
        }
    }

    @Override
    public List<UserModel> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM UserModel", UserModel.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void add(UserModel dataSet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(dataSet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}