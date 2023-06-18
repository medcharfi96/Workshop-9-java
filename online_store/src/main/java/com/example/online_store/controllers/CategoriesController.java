package com.example.online_store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.online_store.dao.entities.Category;
import com.example.online_store.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

  @Autowired
    CategoryService categorieService;

     @GetMapping("/add")
    public String addCategory() {
        return "categorieAdd";
    }

     @GetMapping("/")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categorieService.getCategories());
        return "categories";
    }


     @GetMapping("/{id}")
    public String showCategory(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categorieService.getCategorybyid(id) );
        return "categorieShow";
    }

    @GetMapping("/edit/{id}")
    public String updateCategorie(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categorieService.getCategorybyid(id) );
        return "categorieForm";
    }

     @RequestMapping("/categorie/new")
    public String newCategorie(Model model) {
        model.addAttribute("categories", new Category());
        return "categorieForm";
    }

     @PostMapping("/categorie")
    public String saveCategory(Category category) {
        categorieService.addCategory(category);
        return "redirect:/categories/";
    }

     @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categorieService.deleteCategory(id);
        return "redirect:/categories/";
    }



    
    
}