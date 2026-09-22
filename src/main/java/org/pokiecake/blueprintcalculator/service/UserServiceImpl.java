package org.pokiecake.blueprintcalculator.service;

import org.pokiecake.blueprintcalculator.dao.RoleDao;
import org.pokiecake.blueprintcalculator.dao.UserDao;
import org.pokiecake.blueprintcalculator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;
    RoleDao roleDao;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findByUserName(String userName) {
        return userDao.findUserByUsername(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);

        //check for error

        //collect user's authorities
        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(roleDao.getUserRoles(user.getId()));

        //create new userdetails
        return null;
    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> role) {
        return null;
    }
}
