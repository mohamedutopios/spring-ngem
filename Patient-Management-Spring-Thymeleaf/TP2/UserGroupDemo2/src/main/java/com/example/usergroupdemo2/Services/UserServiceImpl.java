package com.example.usergroupdemo2.Services;


import com.example.usergroupdemo2.entities.Role;

import com.example.usergroupdemo2.entities.Utilisateur;
import com.example.usergroupdemo2.repositories.RoleRepositoriy;
import com.example.usergroupdemo2.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service //component Couche metier
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
   private RoleRepositoriy roleRepositoriy;
    @Override
    public Utilisateur addNewUser(Utilisateur user) {
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepositoriy.save(role);
    }

    @Override
    public Utilisateur findUserbyUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepositoriy.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        Utilisateur user=findUserbyUserName(userName);
Role role = findRoleByRoleName(roleName);
if(user.getRoles()!=null) {
    user.getRoles().add(role);
    role.getUsers().add(user);
    //userRepository.save(user);
}
    }

    @Override
    public Utilisateur authenticate(String userName, String password) {
        Utilisateur user = userRepository.findByUsername(userName);
        if(user==null){
            throw new RuntimeException("Bas credentials");
        }
      if(user.getPassword().equals(password)){return user;}
      throw new RuntimeException("Bad credentials");
    }
}
