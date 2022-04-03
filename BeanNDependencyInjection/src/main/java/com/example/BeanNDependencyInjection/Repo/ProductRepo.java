package com.example.BeanNDependencyInjection.Repo;

import com.example.BeanNDependencyInjection.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>
{
}
