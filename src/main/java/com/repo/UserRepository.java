package com.repo;


import org.springframework.data.repository.CrudRepository;
import com.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String username);
}
