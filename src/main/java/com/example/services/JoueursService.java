package com.example.services;

import com.example.entities.Equipe;
import com.example.entities.Joueurs;
import com.example.entities.Utilisateurs;
import com.example.interfaces.Repository;

import java.util.List;

public class JoueursService  extends BaseService implements Repository<Joueurs> {
    @Override
    public boolean create(Utilisateurs o) {
        return false;
    }

    @Override
    public boolean create(Equipe o) {
        return false;
    }

    @Override
    public boolean create(Joueurs o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Joueurs o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Joueurs o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Joueurs findById(int id) {
        Joueurs joueurs = null;
        session = sessionFactory.openSession();
        joueurs = (Joueurs) session.get(Joueurs.class, id);
        session.close();
        return joueurs;
    }

    @Override
    public List<Joueurs> findAll() {
        List<Joueurs> joueursList = null;
        session = sessionFactory.openSession();
        joueursList = session.createQuery("from Joueurs").list();
        session.close();
        return joueursList;

    }


}
