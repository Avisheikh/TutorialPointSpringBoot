package com.practise.register.repo;

import com.practise.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
    @Query(value = "select exists(select * from user t where t.email= :email)",nativeQuery = true)
    int checkEmailExist(@Param("email") String email);

    @Query(value = "select exists(select * from user t where t.phone_number= :phone_number)",nativeQuery = true)
    int checkPhoneNumberExist(@Param("phone_number") int phoneNumber);

}
