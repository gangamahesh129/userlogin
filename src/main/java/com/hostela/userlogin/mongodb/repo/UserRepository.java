package com.hostela.userlogin.mongodb.repo;

import com.hostela.userlogin.mongodb.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "mangoUserRepositary")
public interface UserRepository extends MongoRepository<User, Integer> {
}

