package com.codegym.model.employee;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserRole implements Serializable {
    @Id
    @ManyToOne
    private Role role;
    @Id
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
