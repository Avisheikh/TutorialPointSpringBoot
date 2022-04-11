package com.practise.register.repo;

import com.practise.register.model.ModifyUser;
import com.practise.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModifyUserRepo extends JpaRepository<ModifyUser, Integer>
{

    @Query(value ="select * from modify_user where id= :id" , nativeQuery = true)
    ModifyUser customFindById(int id);

}
