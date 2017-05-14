package com.doronzehavi.newsitemweb.model.user;

import com.doronzehavi.newsitemweb.model.role.Role;
import com.doronzehavi.newsitemweb.model.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "feed_user")
@Entity
public class User extends BaseEntity{

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private String username;
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(){
        super();
        this.roles = new HashSet<>();
    }

    public User(String username, String email, String password, Set<Role> roles) {
        this();
        this.username = username;
        this.email = email;
        setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password){
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String[] getRoleNames(){
        String[] roleNames = new String[roles.size()];
        for (int i = 0; i < roles.size(); i++){
            roleNames[i] = roles.iterator().next().getName();
        }
        return roleNames;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
