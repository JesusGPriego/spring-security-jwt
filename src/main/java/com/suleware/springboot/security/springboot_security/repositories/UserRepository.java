package com.suleware.springboot.security.springboot_security.repositories;

import org.springframework.data.repository.CrudRepository;
import com.suleware.springboot.security.springboot_security.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);

}
