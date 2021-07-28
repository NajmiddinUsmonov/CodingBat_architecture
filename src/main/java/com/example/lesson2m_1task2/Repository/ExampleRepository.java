package com.example.lesson2m_1task2.Repository;

import com.example.lesson2m_1task2.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example,Integer> {
}
