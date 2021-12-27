package com.aysegulapc.springboot.thirdhomework.repository;

import com.aysegulapc.springboot.thirdhomework.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
