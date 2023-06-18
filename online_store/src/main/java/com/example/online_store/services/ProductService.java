package com.example.online_store.services;

import java.util.List;

import com.example.online_store.dao.entities.Products;

public interface ProductService {
    Products addProduct (Products p );
    Products productById(long id);
    void deleteProduct (long id);
    List<Products> getProducts();
    void updateProducts(Products p); 
    
}