package com.doronzehavi.newsitemweb.service;


import com.doronzehavi.newsitemweb.model.user.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
