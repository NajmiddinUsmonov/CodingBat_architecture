package com.example.lesson2m_1task2.Repository;

import com.example.lesson2m_1task2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmailAndPassword(String email,String password);
    boolean existsByEmailAndIdNot(String email,Integer id);
    boolean existsByEmail(String email);
}
