package com.practise.register.repo;

import com.practise.register.model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepo extends JpaRepository<Authentication,Integer>
{

    @Query(value = "select is_authenticated from authentication t where t.id= 1",nativeQuery = true)
    boolean is_authentication();

}
