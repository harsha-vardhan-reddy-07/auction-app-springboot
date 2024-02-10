package com.auction.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.models.TransactionModel;

public interface TransactionRepo extends MongoRepository<TransactionModel, String>{

    
} 
