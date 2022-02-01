package com.rs.services.jpaservices;

import com.rs.domain.User;
import com.rs.services.UserService;
import com.rs.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * created by rs 1/31/2022.
 */
@Service
@Profile("jpadao")
public class UserServiceJpaDaoImpl extends AbstractJpaDaoService implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select username from User",User.class).getResultList();
    }

    @Override
    public User getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class,id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }

        User saveduser = em.merge(domainObject);
        em.getTransaction().commit();

        return saveduser;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }

    @Override
    public User findByUsername(String userName) {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("select username from User where username = :username", User.class)
                .setParameter("username", userName).getSingleResult();
    }
}
