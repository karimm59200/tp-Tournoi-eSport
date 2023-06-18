package com.example.services;

import com.example.entities.Equipe;
import com.example.entities.Joueurs;
import com.example.entities.Utilisateurs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class  BaseService {

    protected StandardServiceRegistry registre;

    protected SessionFactory sessionFactory;

    protected Session session;

    public BaseService() {
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

    }

    public abstract boolean create(Utilisateurs o);

    public abstract boolean create(Equipe o);

    public abstract boolean create(Joueurs o);
}
