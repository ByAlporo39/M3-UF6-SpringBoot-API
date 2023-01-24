/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ponce.API.service;

import com.ponce.API.model.Product;
import com.ponce.API.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alvaroponrod
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    
    public List<Product>listProducts(){
        return repository.findAll();
    }
    public void keepProduct(Product product){
        repository.save(product);
    }
    public Product obtainProductId (Integer id){
        return repository.findById(id).get();
    }
    public void deleteProduct (Integer id){
        repository.deleteById(id);
    }
}
