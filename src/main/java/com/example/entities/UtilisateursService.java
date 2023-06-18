package com.example.entities;

import com.example.interfaces.Repository;
import com.example.services.BaseService;

import java.util.List;

public class UtilisateursService extends BaseService implements Repository<Utilisateurs> {

        @Override
        public boolean create(Utilisateurs o) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            session.close();
            return true;
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
        public boolean update(Utilisateurs o) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }

        @Override
        public boolean delete(Utilisateurs o) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }

        @Override
        public Utilisateurs findById(int id) {
            Utilisateurs utilisateurs = null;
            session = sessionFactory.openSession();
            utilisateurs = (Utilisateurs) session.get(Utilisateurs.class, id);
            session.close();
            return utilisateurs;
        }

        @Override
        public List<Utilisateurs> findAll() {
            List<Utilisateurs> utilisateursList = null;
            session = sessionFactory.openSession();
            utilisateursList = session.createQuery("from Utilisateurs").list();
            session.close();
            return utilisateursList;
        }

}
