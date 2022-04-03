package com.example.BeanNDependencyInjection.Repo;

import com.example.BeanNDependencyInjection.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Integer>
{
}
