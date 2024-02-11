package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Microservice-Product";
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAllProducts();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addNew(@RequestBody Product product){
        return service.createProduct(product);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product productById;
        try {
            productById = service.getProductById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Product());
        }
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.deleteProduct(id);
    }

}
