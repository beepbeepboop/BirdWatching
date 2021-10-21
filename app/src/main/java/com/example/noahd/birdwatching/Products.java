package com.example.noahd.birdwatching;

public class Products {
    String ProductName;
    Double ProductPrice;
    int    ProductImage;
    int    CartQuantity=0;

    public Products(String productName, Double productPrice, int productImage) {
        ProductName = productName;
        ProductPrice = productPrice;
        ProductImage = productImage;
    }

}