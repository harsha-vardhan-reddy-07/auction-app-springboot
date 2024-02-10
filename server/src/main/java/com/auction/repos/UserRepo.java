package com.auction.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.models.UserModel;

public interface UserRepo extends MongoRepository<UserModel, String>{

     UserModel findByEmail(String email);
}
