package com.example.pfenningvaadin2022mysql3.login.loginRepository;

import com.example.pfenningvaadin2022mysql3.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);

    User getByActivationCode(String activationCode);

    @Query("select u from User u where lower(u.username) like lower(concat('%', :username, '%'))")

    List<User> findAllByName(@Param("username")String username);
}
