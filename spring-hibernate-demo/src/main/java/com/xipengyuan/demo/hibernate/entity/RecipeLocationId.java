package com.xipengyuan.demo.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RecipeLocationId implements Serializable {

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "recipe_pk")
    private Long recipePk;
}
