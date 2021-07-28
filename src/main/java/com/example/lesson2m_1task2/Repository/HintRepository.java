package com.example.lesson2m_1task2.Repository;

import com.example.lesson2m_1task2.entity.Hint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HintRepository extends JpaRepository<Hint,Integer> {
}
