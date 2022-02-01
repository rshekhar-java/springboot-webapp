package com.rs.services.jpaservices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * created by rs 1/31/2022.
 */
public class AbstractJpaDaoService {

    protected EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
