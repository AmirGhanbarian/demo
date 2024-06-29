package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table( name = "demo_usertb")
@Getter
@Setter
public class DemoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_username")
    String username;

    @OneToMany(mappedBy = "demo_user")
    private List<Address> address;
}
