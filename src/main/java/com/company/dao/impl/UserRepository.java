package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByNameAndSurname(String name, String surname);

}
