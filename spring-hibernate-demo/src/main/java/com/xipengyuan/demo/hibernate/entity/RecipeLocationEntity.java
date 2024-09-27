package com.xipengyuan.demo.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_recipe_location")
@Getter
@Setter
public class RecipeLocationEntity {

    @EmbeddedId
    private RecipeLocationId id;

    @Column(name = "active_flag")
    private String activeFlag;
}
