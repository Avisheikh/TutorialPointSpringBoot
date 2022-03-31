package com.practise.register.repo;

import com.practise.register.model.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempUserRepo extends JpaRepository<TempUser, Integer>
{
}
