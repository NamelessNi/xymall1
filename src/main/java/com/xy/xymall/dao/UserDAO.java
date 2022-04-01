package com.xy.xymall.dao;

import com.xy.xymall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {

    User findByName(String name);
    User getByNameAndPassword(String name, String password);
}
