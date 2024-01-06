package com.xipengyuan.demo.jpa.persistence.entity;

import com.xipengyuan.demo.jpa.enumeration.Grade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_num")
    private String number;

    private String name;

    private Integer age;

    @Enumerated
    private Grade grade;

    private String email;
}
