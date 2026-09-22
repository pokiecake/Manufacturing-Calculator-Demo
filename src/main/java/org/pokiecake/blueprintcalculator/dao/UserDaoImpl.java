package org.pokiecake.blueprintcalculator.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.pokiecake.blueprintcalculator.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("from User where username=:name", User.class);

        return query.getSingleResult();
    }
}
