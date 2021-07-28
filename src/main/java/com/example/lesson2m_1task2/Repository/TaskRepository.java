package com.example.lesson2m_1task2.Repository;

import com.example.lesson2m_1task2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
