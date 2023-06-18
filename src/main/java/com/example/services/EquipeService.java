package com.example.services;

import com.example.entities.Equipe;
import com.example.entities.Joueurs;
import com.example.entities.Utilisateurs;
import com.example.interfaces.Repository;

import java.util.List;

public class EquipeService  extends BaseService implements Repository<Equipe> {

    @Override
    public boolean create(Utilisateurs o) {
        return false;
    }

    @Override
    public boolean create(Equipe o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean create(Joueurs o) {
        return false;
    }

    @Override
    public boolean update(Equipe o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Equipe o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Equipe findById(int id) {
        Equipe equipe = null;
        session = sessionFactory.openSession();
        equipe = (Equipe) session.get(Equipe.class, id);
        session.close();
        return equipe;
    }

    @Override
    public List<Equipe> findAll() {
        List<Equipe> equipeList = null;
        session = sessionFactory.openSession();
        equipeList = session.createQuery("from Equipe").list();
        session.close();
        return equipeList;

    }
}
