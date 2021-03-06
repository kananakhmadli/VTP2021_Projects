package com.buta.inter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDAO {

    private EntityManagerFactory emf = null;

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("stem");

        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;

    }

    public void closeEmf() {
        emf.close();
    }

}
