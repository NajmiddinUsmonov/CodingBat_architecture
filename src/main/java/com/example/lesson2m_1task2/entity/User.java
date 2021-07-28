package com.example.lesson2m_1task2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = {"email","password"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//email qilsa boladi

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}
