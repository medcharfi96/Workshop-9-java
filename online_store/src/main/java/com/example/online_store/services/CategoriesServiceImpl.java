package com.example.online_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.online_store.dao.entities.Category;
import com.example.online_store.dao.repositories.CategoryRepository;

@Service
public class CategoriesServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRep;

  @Override
  public Category addCategory(Category c) {
    return categoryRep.save(c);
  }

  @Override
  public void deleteCategory(Long id) {
    categoryRep.deleteById(id);
  }

  @Override
  public List<Category> getCategories() {
    return categoryRep.findAll();
  }

  @Override
  public Category updateCategory(Category c) {
    return categoryRep.save(c);
  }

  @Override
  public Category getCategorybyid(Long id) {
    return categoryRep.getById(id);
  }

 

}