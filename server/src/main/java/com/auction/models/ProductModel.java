package com.auction.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "products")
public class ProductModel {

    public String _id;
    public String sellerId;
    public String sellerName;
    public String sellerEmail;
    public String title;
    public String description;
    public String mainImg;
    public String category;
    public List<String> carousel;
    public String auctionCloseTime;
    public String startPrice;
    public String topBidderId = "";
    public String topBidderName = "";
    public String topBidderEmail = "";
    public Number topBidderAmount = 0;
    public String status = "Available";

    public ProductModel(){

    }

    public String get_id() {
        return _id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
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

    public String getCategory() {
        return category;
    }

    public List<String> getCarousel() {
        return carousel;
    }

    public String getAuctionCloseTime() {
        return auctionCloseTime;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public String getTopBidderId() {
        return topBidderId;
    }

    public String getTopBidderName() {
        return topBidderName;
    }

    public String getTopBidderEmail() {
        return topBidderEmail;
    }

    public Number getTopBidderAmount() {
        return topBidderAmount;
    }


    public String getStatus() {
        return status;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCarousel(List<String> carousel) {
        this.carousel = carousel;
    }

    public void setAuctionCloseTime(String auctionCloseTime) {
        this.auctionCloseTime = auctionCloseTime;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    
    public void setTopBidderId(String topBidderId) {
        this.topBidderId = topBidderId;
    }

    public void setTopBidderName(String topBidderName) {
        this.topBidderName = topBidderName;
    }

    public void setTopBidderEmail(String topBidderEmail) {
        this.topBidderEmail = topBidderEmail;
    }

    public void setTopBidderAmount(Number topBidderAmount) {
        this.topBidderAmount = topBidderAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    
}
