package com.practise.register.repo;

import com.practise.register.model.ModifyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModifyUserRepo extends JpaRepository<ModifyUser, Integer>
{

}
