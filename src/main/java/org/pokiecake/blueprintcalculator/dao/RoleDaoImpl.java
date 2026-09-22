package org.pokiecake.blueprintcalculator.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.pokiecake.blueprintcalculator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    EntityManager entityManager;
    UserDao userDao;

    @Autowired
    public RoleDaoImpl(EntityManager entityManager, UserDao userDao) {
        this.entityManager = entityManager;
        this.userDao = userDao;
    }

    public List<Role> getUserRoles(int userId) {
        String username = userDao.findUserById(userId).getUsername();

        TypedQuery<Role> query = entityManager.createQuery("from Role where name=:name", Role.class);
        query.setParameter("name", username);

        return query.getResultList();
    }
}
