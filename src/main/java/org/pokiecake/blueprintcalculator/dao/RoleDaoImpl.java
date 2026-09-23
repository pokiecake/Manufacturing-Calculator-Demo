package org.pokiecake.blueprintcalculator.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.pokiecake.blueprintcalculator.entity.Role;
import org.pokiecake.blueprintcalculator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @Override
    public List<Role> getUserRoles(int userId) {
        TypedQuery<Role> query = entityManager.createQuery("from Role where user_id=:id", Role.class);
        query.setParameter("id", userId);

        List<Role> roles = query.getResultList();
        System.out.println("In getUserRoles");
        System.out.println(roles);

        return roles;
    }
}
