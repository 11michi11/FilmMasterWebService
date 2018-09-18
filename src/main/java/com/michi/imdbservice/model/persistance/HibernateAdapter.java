package com.michi.imdbservice.model.persistance;

import com.michi.imdbservice.model.Film;
import com.michi.imdbservice.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateAdapter implements Persistance {

    private static SessionFactory factory;
    private static HibernateAdapter instance;

    private HibernateAdapter() {
        try {
            factory = new Configuration().configure("/hibernate/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static HibernateAdapter getInstance() {
        if (instance == null)
            instance = new HibernateAdapter();
        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            List<User> users = session.createQuery("FROM User ").list();
            tx.commit();
            return users;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public void addUser(User user) {
        int id = add(user);
        if (id != -1)
            user.setID(id);
    }

    @Override
    public void updateUser(User user){
        update(user);
    }

    @Override
    public List<Film> getAllFilms() {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            List<Film> films = session.createQuery("FROM Film ").list();
            tx.commit();
            return films;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public void addFilm(Film film) {
        add(film);
    }

    private int add(Object obj) {
        Transaction tx = null;
        int id = -1;

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            id = (int) session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return id;
    }

    private void update(Object obj) {
        Transaction tx = null;

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
