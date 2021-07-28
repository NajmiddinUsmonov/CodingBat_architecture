package com.example.lesson2m_1task2.Repository;

import com.example.lesson2m_1task2.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution,Integer> {
}
