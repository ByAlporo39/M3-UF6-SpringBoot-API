/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ponce.API.controller;

import com.ponce.API.model.Product;
import com.ponce.API.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alvaroponrod
 */
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> obtainProduct(@PathVariable Integer id) {
        try {
            Product product = productService.obtainProductId(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/product")
    public void newProduct (@RequestBody Product product){
        productService.keepProduct(product);
    }
    
    @PutMapping("/product/{id}")
    public ResponseEntity<?> editProduct (@RequestBody Product product, @PathVariable Integer id){
        try{
            Product productExist = productService.obtainProductId(id);
            productExist.setProduct_name(product.getProduct_name());
            productExist.setPrice(product.getPrice());
            productService.keepProduct(productExist);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
