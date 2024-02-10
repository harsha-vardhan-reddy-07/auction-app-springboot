package com.auction.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auction.models.BidsModel;
import com.auction.models.CategoryModel;
import com.auction.models.ProductModel;
import com.auction.models.TransactionModel;
import com.auction.models.UserModel;
import com.auction.repos.BidsRepo;
import com.auction.repos.CategoryRepo;
import com.auction.repos.ProductRepo;
import com.auction.repos.TransactionRepo;
import com.auction.repos.UserRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Controller
public class RouteController {

    @Autowired
    BidsRepo bidsRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    UserRepo userRepo;



    @PostMapping("/register")
    public UserModel registerMethod(@RequestBody UserModel userData) {
        try {
            UserModel user = userRepo.save(userData);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/login")
    public UserModel loginMethod(@RequestBody UserModel userData) {
        try {
            UserModel user = userRepo.findByEmail(userData.getEmail());
            if (user.getPassword().equals(userData.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/fetch-user/{id}")
    public UserModel fetchUserMethod(@PathVariable("id") String id) {
        try {
            UserModel user = userRepo.findById(id).get();
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-users")
    public List<UserModel> fetchAllUsersMethod() {
        try {
            List<UserModel> users = userRepo.findAll();
            return users;
        } catch (Exception e) {
            return null;
        }
    }


    @PostMapping("/deposit/{id}")
    public TransactionModel depositMethod(@PathVariable("id") String id ,@RequestBody TransactionModel transactionData) {
        try {
            transactionData.setUserId(id);
            TransactionModel transaction = transactionRepo.save(transactionData);

            UserModel user = userRepo.findById(id).get();
            user.setFunds(user.getFunds().doubleValue() + transaction.getAmount().doubleValue());
            userRepo.save(user);

            return transaction;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/user-withdraw/{id}")
    public TransactionModel userWithdrawMethod(@PathVariable("id") String id ,@RequestBody TransactionModel transactionData) {
        try {
            transactionData.setUserId(id);
            TransactionModel transaction = transactionRepo.save(transactionData);

            UserModel user = userRepo.findById(id).get();
            user.setFunds(user.getFunds().doubleValue() - transaction.getAmount().doubleValue());
            userRepo.save(user);

            return transaction;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-transactions")
    public List<TransactionModel> fetchAllTransactionsMethod() {
        try {
            List<TransactionModel> transactions = transactionRepo.findAll();
            return transactions;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/approve-seller/{id}")
    public UserModel approveSellerMethod(@PathVariable("id") String id) {
        try {
            UserModel user = userRepo.findById(id).get();
            user.setApproval("Accepted");
            userRepo.save(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/reject-seller/{id}")
    public UserModel rejectSellerMethod(@PathVariable("id") String id) {
        try {
            UserModel user = userRepo.findById(id).get();
            user.setApproval("Rejected");
            userRepo.save(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/seller-fund-withdraw/{id}")
    public UserModel sellerFundWithdrawMethod(@PathVariable("id") String id) {
        try {
            UserModel user = userRepo.findById(id).get();
            user.setFunds(0);
            userRepo.save(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    } 

    @GetMapping("/fetch-product-details/{id}")
    public ProductModel fetchProductDetailsMethod(@PathVariable("id") String id) {
        try {
            ProductModel product = productRepo.findById(id).get();
            return product;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-products")
    public List<ProductModel> fetchAllProductsMethod() {
        try {
            List<ProductModel> products = productRepo.findAll();
            return products;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-bids")
    public List<BidsModel> fetchAllBidsMethod() {
        try {
            List<BidsModel> bids = bidsRepo.findAll();
            return bids;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-categories")
    public List<CategoryModel> fetchAllCategoriesMethod() {
        try {
            List<CategoryModel> categories = categoryRepo.findAll();
            return categories;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/add-new-product")
    public ProductModel addNewProductMethod(@RequestBody ProductModel productData) {
        try {

            CategoryModel category = categoryRepo.findById("main").orElse(null);

            if (category == null) {
                category = new CategoryModel();
                category.set_id("main");
                category.getCategories().add(productData.getCategory());
                categoryRepo.save(category);
            }else{
                if (!Arrays.asList(category.getCategories()).contains(productData.getCategory())) {
                    category.getCategories().add(productData.getCategory());
                    categoryRepo.save(category);
                }
            }

            ProductModel product = productRepo.save(productData);
            return product;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/update-product/{id}")
    public ProductModel updateProductMethod(@PathVariable("id") String id, @RequestBody ProductModel productData) {
        try {
            CategoryModel category = categoryRepo.findById("main").orElse(null);

            ProductModel product = productRepo.findById(id).get();

            if (!Arrays.asList(category.getCategories()).contains(productData.getCategory())) {
                category.getCategories().add(productData.getCategory());
                categoryRepo.save(category);
            }

            product.setCategory(productData.getCategory());

            product.setTitle(productData.getTitle());
            product.setDescription(productData.getDescription());
            product.setMainImg(productData.getMainImg());
            product.setCarousel(productData.getCarousel());
            product.setAuctionCloseTime(productData.getAuctionCloseTime());
            product.setStartPrice(productData.getStartPrice());
            
            productRepo.save(product);
            return product;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/make-bidding")
    public BidsModel makeBiddingMethod(@RequestBody BidsModel bidData) {
        try {

            ProductModel product = productRepo.findById(bidData.getProductId()).get();
            
            if (product.getTopBidderAmount().doubleValue() < bidData.getBidAmount().doubleValue()) {
                product.setTopBidderId(bidData.getBidderId());
                product.setTopBidderName(bidData.getBidderName());
                product.setTopBidderEmail(bidData.getBidderEmail());
                product.setTopBidderAmount(bidData.getBidAmount());
                productRepo.save(product);
            }
            bidData.setSellerId(product.getSellerId());
            BidsModel bid = bidsRepo.save(bidData);
            return bid;
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping("/close-bidding/{id}")
    public ProductModel closeBiddingMethod(@PathVariable("id") String id) {
        try {
            ProductModel product = productRepo.findById(id).get();
            
            if (product.getTopBidderId() == "" || product.getTopBidderId() == null){
                
                product.setStatus("Unsold");
            } else{
                product.setStatus("Sold");
                UserModel seller = userRepo.findById(product.getSellerId()).get();
                UserModel bidder = userRepo.findById(product.getTopBidderId()).get();
                
                seller.setFunds(seller.getFunds().doubleValue() + product.getTopBidderAmount().doubleValue());
                bidder.setFunds(bidder.getFunds().doubleValue() - product.getTopBidderAmount().doubleValue());
                
                userRepo.save(seller);
                userRepo.save(bidder);

                TransactionModel transaction = new TransactionModel();
                transaction.setUserId(bidder.get_id());
                transaction.setUserName(bidder.getUsername());
                transaction.setPaymentMethod("Auction Payment");
                transaction.setAmount(product.getTopBidderAmount());
                transaction.setTransactionType("Auction");

                DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                transaction.setTime(currentDate.format(now));

                transactionRepo.save(transaction);

            }
            
            productRepo.save(product);
            return product;
        } catch (Exception e) {
            return null;
        }
    }
    
}
