package com.example.BeanNDependencyInjection.Controller;

import com.example.BeanNDependencyInjection.Entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestServiceController
{
    private static Map<String, Product> productRepo = new HashMap<>();

    static
    {
        Product honey = new Product();

        honey.setId("1");
        honey.setName("MadHoney");
        productRepo.put(honey.getId(), honey);

        Product water = new Product();
        water.setId("2");
        water.setName("pani");
        productRepo.put(water.getId(), water);
    }

    @RequestMapping("/product")
    public ResponseEntity<Object> getProduct()
    {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create_product", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product)
    {
        System.out.println(product);
        productRepo.put(product.getId(),product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);

    }


    
}
