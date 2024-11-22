package com.example.usergroupdemo2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="ROLES")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="DESCRIPTION")
    private String desc;
    @Column(length=20,unique=true)
    private String roleName;
    @ToString.Exclude
    @ManyToMany(fetch= FetchType.EAGER,mappedBy = "roles")
    private List<Utilisateur> users=new ArrayList<>();
}
