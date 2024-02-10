package com.auction.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.models.ProductModel;

public interface ProductRepo extends MongoRepository<ProductModel, String>{

    
}
