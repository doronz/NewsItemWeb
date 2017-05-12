package com.doronzehavi.newsitemweb.dao.user;

import com.doronzehavi.newsitemweb.dao.source.NewsSourceRepository;
import com.doronzehavi.newsitemweb.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
