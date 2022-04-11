package com.practise.register.repo;

import com.practise.register.model.TempUser;
import com.practise.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
    @Query(value = "select exists(select * from user t where t.email= :email)",nativeQuery = true)
    int checkEmailExist(@Param("email") String email);

    @Query(value = "select exists(select * from user t where t.phone_number= :phone_number)",nativeQuery = true)
    int checkPhoneNumberExist(@Param("phone_number") int phoneNumber);

    @Query(value = "select * from user u where u.email= :email", nativeQuery = true)
    Optional<User> customFindByEmail(@Param("email") String email);

    @Query(value = "select * from user where id= :id", nativeQuery = true)
    User customFindById(int id);
}
