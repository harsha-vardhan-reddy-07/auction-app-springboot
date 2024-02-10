package com.auction.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.models.BidsModel;

public interface BidsRepo extends MongoRepository<BidsModel, String>{
    
}
