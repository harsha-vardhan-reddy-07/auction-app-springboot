package com.auction.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "transactions")
public class TransactionModel {

    public String _id;
    public String userId;
    public String userName;
    public String transactionType;
    public String paymentMethod;
    public Number amount;
    public String time;

    public TransactionModel(){

    }

    public String get_id() {
        return _id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Number getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
