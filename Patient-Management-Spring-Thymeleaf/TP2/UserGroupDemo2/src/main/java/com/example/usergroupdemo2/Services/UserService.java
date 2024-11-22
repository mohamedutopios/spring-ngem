package com.example.usergroupdemo2.Services;


import com.example.usergroupdemo2.entities.Role;
import com.example.usergroupdemo2.entities.Utilisateur;

public interface UserService {
    Utilisateur addNewUser(Utilisateur user);
    Role addNewRole(Role role);
    Utilisateur findUserbyUserName(String userName);
    Role findRoleByRoleName(String roleName);

    void addRoleToUser(String userName,String roleName);
    Utilisateur authenticate(String userName, String password);
}
