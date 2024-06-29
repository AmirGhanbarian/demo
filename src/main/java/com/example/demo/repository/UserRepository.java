package com.example.demo.repository;

import com.example.demo.model.DemoUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<DemoUser,Long> {
    DemoUser findById(long id);
}


