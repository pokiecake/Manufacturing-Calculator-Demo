package org.pokiecake.blueprintcalculator.dao;

import javax.management.relation.Role;
import java.util.List;

public interface RoleDao {

    public List<Role> getUserRoles(int userId);
}
