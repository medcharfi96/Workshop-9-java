package com.example.online_store.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_store.dao.entities.Products;
import com.example.online_store.dao.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRep ;

    @Override
    public Products addProduct(Products p) {
       return productRep.save(p); 
    }

    @Override
    public void deleteProduct(long id ) {
        productRep.deleteById(id);
    }

    @Override
    public List<Products> getProducts() {
      return productRep.findAll();
    }

    @Override
    public void updateProducts(Products p) {
      productRep.save(p);
    }

    @Override
    public Products productById(long id) {
     return productRep.getById(id);
    } 

    
    
}