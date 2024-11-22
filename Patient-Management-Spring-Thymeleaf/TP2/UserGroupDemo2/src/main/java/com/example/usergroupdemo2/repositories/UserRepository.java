package com.example.usergroupdemo2.repositories;



import com.example.usergroupdemo2.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // component couche DAO
public interface UserRepository extends JpaRepository<Utilisateur,String> {
    Utilisateur findByUsername(String userName);
}
