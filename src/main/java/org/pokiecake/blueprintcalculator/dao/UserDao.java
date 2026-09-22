package org.pokiecake.blueprintcalculator.dao;

import org.pokiecake.blueprintcalculator.entity.User;

public interface UserDao {

    User findUserByUsername(String username);

}
