package com.doronzehavi.newsitemweb.dao.user;

import com.doronzehavi.newsitemweb.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
}
