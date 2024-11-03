package com.suleware.springboot.security.springboot_security.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.suleware.springboot.security.springboot_security.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
