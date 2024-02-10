package com.auction.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "bids")
public class BidsModel {
    
    public String _id;
    public String productId;
    public String sellerId;
    public String title;
    public String description;
    public String mainImg;
    public String bidderId;
    public String bidderName;
    public String bidderEmail;
    public Number bidAmount;
    public String bidTime;

    public BidsModel(){

    }

    public String get_id() {
        return _id;
    }

    public String getProductId() {
        return productId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMainImg() {
        return mainImg;
    }

    public String getBidderId() {
        return bidderId;
    }

    public String getBidderName() {
        return bidderName;
    }

    public String getBidderEmail() {
        return bidderEmail;
    }

    public Number getBidAmount() {
        return bidAmount;
    }

    public String getBidTime() {
        return bidTime;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public void setBidderEmail(String bidderEmail) {
        this.bidderEmail = bidderEmail;
    }

    public void setBidAmount(Number bidAmount) {
        this.bidAmount = bidAmount;
    }

    public void setBidTime(String bidTime) {
        this.bidTime = bidTime;
    }

    
}
