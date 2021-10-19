package com.iiitn.foodcourt.service;

import com.iiitn.foodcourt.Exception.NotFoundException;
import com.iiitn.foodcourt.model.Product;
import com.iiitn.foodcourt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return  products;
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElseThrow(()->new NotFoundException("Product by id " + id + "was not found"));
    }
    public  Product addProduct(Product product){
        return productRepository.save(product);
    }
    public  Product updateProduct(Product product,int id){
        Product temp = getProductById(id);
        if (temp != null)
            return productRepository.save(product);
        return product;
    }
    public  void deleteProduct(Product product){
        this.deteleProductById(product.getId());
    }
    public void deteleProductById(int id){
        productRepository.deleteById(id);
    }
}
