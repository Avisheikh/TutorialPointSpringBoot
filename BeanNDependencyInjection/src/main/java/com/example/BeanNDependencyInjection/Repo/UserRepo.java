package com.example.BeanNDependencyInjection.Repo;


import com.example.BeanNDependencyInjection.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
}
