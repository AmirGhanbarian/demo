package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity
@Table( name = "demo_usertb")
@Getter
public class DemoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_username")
    String username;

    @Column(name = "user_address")

    @OneToMany(mappedBy = "address")
    private Set<Address> address;
}
