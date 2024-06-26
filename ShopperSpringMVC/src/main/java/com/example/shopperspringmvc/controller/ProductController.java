package com.example.shopperspringmvc.controller;

import com.example.shopperspringmvc.entity.Product;
import com.example.shopperspringmvc.rep.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRep productRep;

    @GetMapping("/")
    public String productList(Model model) {
        List<Product> products = productRep.findAll();
        model.addAttribute("products", products);
        return "product-list"; // Ensure this file exists in src/main/resources/templates
    }

    @GetMapping("/create")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productRep.save(product);
        return "redirect:/"; // Redirect to root URL to show updated product list
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){

        productRep.deleteById(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productRep.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "edit-product";
    }
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        Product product1 = productRep.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid product Id:" + id));
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        productRep.save(product1);
        return "redirect:/";
    }
}
