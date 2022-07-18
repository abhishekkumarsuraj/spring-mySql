package com.react.backend.reactbackend.controller;

import com.react.backend.reactbackend.entity.Product;
import com.react.backend.reactbackend.model.ProductModel;
import com.react.backend.reactbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/greet")
    public String greet(){
        return "Hello World !";
    }

    @PostMapping(path = "/createProduct")
    public Product createProduct(@RequestBody ProductModel productModel){
        Product product = new Product();
        product.setName(productModel.getName());
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());
        return productRepository.save(product);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/getProducts")
    @ResponseBody
    public Iterable<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/getProduct/{id}")
    public Product getProduct(@PathVariable int id) {
        Product product =  new Product();
        Optional<Product> optionalProduct =productRepository.findById(id);
        return optionalProduct.orElse(product);
    }

        @DeleteMapping("/deleteProduct/{id}")
    void deleteEmployee(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
