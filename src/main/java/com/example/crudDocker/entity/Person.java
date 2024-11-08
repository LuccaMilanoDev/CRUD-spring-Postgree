package com.example.crudDocker.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.security.cert.CertPathBuilder;

@Entity
@Table(name = "tb_person")
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private Integer age;


    @Builder
    public Person(String name, String cpf, Integer age){
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }
}
