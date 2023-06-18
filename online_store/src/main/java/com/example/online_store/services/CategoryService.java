package com.example.online_store.services;

import java.util.List;

import com.example.online_store.dao.entities.Category;

public interface CategoryService {
    Category addCategory (Category c);
    void deleteCategory (Long id);
    List <Category> getCategories();
    Category getCategorybyid(Long id);
    Category updateCategory(Category c); 
    
}