package com.example.BeanNDependencyInjection.Controller;

import com.example.BeanNDependencyInjection.Entity.Product;
import com.example.BeanNDependencyInjection.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/get_product")
    public ResponseEntity<Object> getNewProduct()
    {
        return new ResponseEntity<>(productRepo.values() + "new product", HttpStatus.OK);
    }

    @RequestMapping(value = "/create_product", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product)
    {
        System.out.println(product);
        productRepo.put(product.getId(),product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);

    }

    @RequestMapping(value = "/update_product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product)
    {

        if(!productRepo.containsKey(id))
        {
            throw new ProductNotFoundException();
        }

        productRepo.remove(id);
        product.setId(id);
        System.out.println(product.getId());
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is update successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete_product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeProduct(@PathVariable("id") String id)
    {
        if(!productRepo.containsKey(id))
        {
            throw new ProductNotFoundException();
        }
        System.out.println(productRepo.get(id).getId());
        productRepo.remove(id);
        return  new ResponseEntity<>("Product is deleted succesfully", HttpStatus.OK);
    }



    
}
