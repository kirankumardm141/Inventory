package com.inventorysystem.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inventorysystem.dao.ProductRepository;
import com.inventorysystem.entity.Product;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	
	@Autowired
	  private ProductRepository productRepository;
	
	
	 @GetMapping("/products")
	  public List<Product> getAllUsers() {
	    return productRepository.findAll();
	  }
	 
	 @GetMapping("/products/{id}")
	 public Optional<Product> getProduct(@PathVariable long id)
	 {
	   	return productRepository.findById(id);
	 }
	 
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateEmployee(@PathVariable long id,
			@RequestBody Product product){
		System.out.println("Inside Put");
		System.out.println(product);
		Product prod = productRepository.save(product);
		return new ResponseEntity<Product>(product,HttpStatus.OK); 
	}
	
	@PostMapping("/products")
	public ResponseEntity<Void> addProduct(@PathVariable long id,
			@RequestBody Product product){
		System.out.println("Inside Post Method");
		System.out.println(product);
		Product prod = productRepository.save(product);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(prod.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/products")
	public Optional<Product> getProducts()
	{
		
	}
}
