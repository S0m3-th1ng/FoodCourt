package com.iiitn.foodcourt.Controller;

import com.iiitn.foodcourt.model.Product;
import com.iiitn.foodcourt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/find/{id}")
    public  Product getProductById(@PathVariable("id") int id){
        return  productService.getProductById(id);
    }
    @PostMapping("/add")
    public  Product addProduct(@RequestBody Product product){
        return  productService.addProduct(product);
    }
    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable("id") int id){
        return  productService.updateProduct(product,id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable int id){
        productService.deteleProductById(id);
    }
}
