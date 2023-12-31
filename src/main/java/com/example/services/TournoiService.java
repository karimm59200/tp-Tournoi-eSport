package com.example.services;

import com.example.entities.Equipe;
import com.example.entities.Joueurs;
import com.example.entities.Tournoi;
import com.example.entities.Utilisateurs;
import com.example.interfaces.Repository;

import java.util.List;

public class TournoiService extends BaseService implements Repository<Tournoi> {

        @Override
        public boolean create(Tournoi o) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }

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
            return false;
        }

        @Override
        public boolean update(Tournoi o) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }

        @Override
        public boolean delete(Tournoi o) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }

        @Override
        public Tournoi findById(int id) {
            Tournoi tournoi = null;
            session = sessionFactory.openSession();
            tournoi = (Tournoi) session.get(Tournoi.class, id);
            session.close();
            return tournoi;
        }

        @Override
        public List<Tournoi> findAll() {
            List<Tournoi> tournoiList = null;
            session = sessionFactory.openSession();
            tournoiList = session.createQuery("from Tournoi").list();
            session.close();
            return tournoiList;
        }
}
