package com.example.online_store.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_store.dao.entities.Products;

public interface ProductRepository extends JpaRepository<Products,Long>{

    
}