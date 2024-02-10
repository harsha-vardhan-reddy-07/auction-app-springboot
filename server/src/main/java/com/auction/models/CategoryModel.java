package com.auction.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "generals")
public class CategoryModel {

    public String _id;
    public List<String> categories = new ArrayList<String>();
    
    public CategoryModel(){

    }

    public String get_id() {
        return _id;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    
}
