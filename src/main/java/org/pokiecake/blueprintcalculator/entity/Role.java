package org.pokiecake.blueprintcalculator.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    // NOT JPA compliant, use an embedded id or id class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int user_id;

    @Id
    @Column(name="name")
    private String name;

    public Role() {

    }

    public Role(int user_id, String name) {
        this.user_id = user_id;
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                '}';
    }
}
