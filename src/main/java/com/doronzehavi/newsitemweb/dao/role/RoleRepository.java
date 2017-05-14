package com.doronzehavi.newsitemweb.dao.role;

import com.doronzehavi.newsitemweb.model.role.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
