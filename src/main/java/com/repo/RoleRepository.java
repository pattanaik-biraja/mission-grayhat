package com.repo;

import org.springframework.data.repository.CrudRepository;
import com.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{
}
