package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "demo_address")
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "address_address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "demo_user")
    @JsonIgnore
    private DemoUser demo_user;

    public Address() {

    }

    public Address(String address) {
        this.address = address;
    }


}
