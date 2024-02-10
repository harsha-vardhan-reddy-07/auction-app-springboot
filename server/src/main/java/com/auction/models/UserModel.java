package com.auction.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "users")
public class UserModel {

    public String _id;
    public String username;
    public String email;
    public String password;
    public String usertype;
    public Number funds = 0;
    public String approval = "Pending";

    public UserModel(){

    }

    public String get_id() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsertype() {
        return usertype;
    }

    public Number getFunds() {
        return funds;
    }

    public String getApproval() {
        return approval;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setFunds(Number funds) {
        this.funds = funds;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }
    
    
}
