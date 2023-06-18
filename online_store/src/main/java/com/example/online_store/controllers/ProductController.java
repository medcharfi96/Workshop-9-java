package com.example.online_store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.online_store.dao.entities.Category;
import com.example.online_store.dao.entities.Products;
import com.example.online_store.services.CategoryService;
import com.example.online_store.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categorieService;

    /*
     * add product
     */
    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("categories", categorieService.getCategories());
        return "productsAdd";
    }

    /*
     * get all product in view
     */
    @GetMapping("/")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }

    /*
     * get product by id in view
     */
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("products", productService.productById(id));
        return "productShow";
    }

    /*
     * show the product in form
     */
    @GetMapping("/edit/{id}")
    public String updateProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("products", productService.productById(id));
        model.addAttribute("categories", categorieService.getCategories());

        return "productForm";
    }

    /*
     * New product
     */
    @RequestMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("products", new Products());
        return "productForm";
    }

    /*
     * Save to DB
     */
    @PostMapping("/product")
    public String saveProduct(@ModelAttribute("product") Products product) {
        //System.out.println("product: " +product.getCategory().getId());
        Category category = categorieService.getCategorybyid(product.getCategory().getId());
        product.setCategory(category);
        productService.addProduct(product);
        return "redirect:/products/";
    }

    /*
     * delete product
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products/";
    }

}