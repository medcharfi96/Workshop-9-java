package com.example.online_store.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_store.dao.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}