package com.example.lesson2m_1task2.Repository;

import com.example.lesson2m_1task2.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
}
