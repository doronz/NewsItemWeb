package com.doronzehavi.newsitemweb.model.user;


import com.doronzehavi.newsitemweb.model.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity{
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;

    protected User(){
        super();
    }

    public User(String username, String email, String password, String[] roles) {
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

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
