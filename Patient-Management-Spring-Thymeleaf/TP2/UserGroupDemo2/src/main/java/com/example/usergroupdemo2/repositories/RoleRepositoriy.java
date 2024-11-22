package com.example.usergroupdemo2.repositories;


import com.example.usergroupdemo2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositoriy extends JpaRepository<Role,String> {
Role findByRoleName(String RoleName);
}
