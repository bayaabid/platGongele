package com.platscongeles.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platscongeles.web.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByRoleName(String name);

}
