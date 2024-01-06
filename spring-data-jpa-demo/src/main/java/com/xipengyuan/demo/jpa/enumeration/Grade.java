package com.xipengyuan.demo.jpa.enumeration;

import lombok.Getter;

@Getter
public enum Grade {

    PRIMARY("小学"),
    SECONDARY("初中"),
    HIGH("高中");

    private final String desc;

    Grade(String desc) {
        this.desc = desc;
    }
}
