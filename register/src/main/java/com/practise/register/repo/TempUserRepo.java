package com.practise.register.repo;

import com.practise.register.model.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TempUserRepo extends JpaRepository<TempUser, Integer>
{
    @Query(value = "select exists(select * from temp_user t where t.email= :email)",nativeQuery = true)
    int checkEmailExist(@Param("email") String email);

    @Query(value = "select exists(select * from temp_user t where t.password= :password)",nativeQuery = true)
    int checkPasswordExist(@Param("password") String password);
}
