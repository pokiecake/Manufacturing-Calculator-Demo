package org.pokiecake.blueprintcalculator.dao;

import org.pokiecake.blueprintcalculator.entity.Role;

import java.util.List;

public interface RoleDao {

    public List<Role> getUserRoles(int userId);
}
