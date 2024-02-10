package com.auction.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.models.CategoryModel;

public interface CategoryRepo extends MongoRepository<CategoryModel, String>{

    
} 
