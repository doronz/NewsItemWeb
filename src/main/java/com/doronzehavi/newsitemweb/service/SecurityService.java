package com.doronzehavi.newsitemweb.service;


import com.doronzehavi.newsitemweb.model.user.User;

import javax.servlet.http.HttpServletRequest;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(User user, HttpServletRequest request);
}
