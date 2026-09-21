package org.pokiecake.blueprintcalculator.service;

import org.pokiecake.blueprintcalculator.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);
}
