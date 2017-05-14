package com.doronzehavi.newsitemweb.model.role;

import com.doronzehavi.newsitemweb.model.core.BaseEntity;
import com.doronzehavi.newsitemweb.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseEntity{
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles", targetEntity = User.class, cascade = CascadeType.ALL)
    private Set<User> users;

    private Role(){
        super();
        this.users = new HashSet<>();
    }

    public Role(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}