package com.example.usergroupdemo2;

import com.example.usergroupdemo2.Services.UserService;
import com.example.usergroupdemo2.entities.Role;
import com.example.usergroupdemo2.entities.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UserGroupDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(UserGroupDemo2Application.class, args);

    }
    
    @Bean
    CommandLineRunner start(UserService userService) {
        return args->{
            Utilisateur u = new Utilisateur();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            Utilisateur u2 = new Utilisateur();
            u.setUsername("admin");
            u.setPassword("123456");
            userService.addNewUser(u2);



            Stream.of("STUDENT","USER","ADMIN").forEach(
                    r ->{
                        Role role1= new Role();
                        role1.setRoleName(r);
                        userService.addNewRole(role1);

                    }
            );

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("admin","User");
            userService.addRoleToUser("admin","ADMIN");

            try {
                Utilisateur user = userService.authenticate("user1","123456");
                System.out.println(user.getUserid());
                System.out.println(user.getUsername());
                System.out.println("Roles=>");
                user.getRoles().forEach(
                        r->{
                            System.out.println("Roles=>"+r);
                }
                );
            }
            catch (Exception exception){

                exception.printStackTrace();

            }

        };
    }

}
