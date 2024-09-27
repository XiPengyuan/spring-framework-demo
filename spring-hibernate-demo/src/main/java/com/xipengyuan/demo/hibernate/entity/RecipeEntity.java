package com.xipengyuan.demo.hibernate.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_recipe")
public class RecipeEntity {

    @Id
    private Long id;
}
