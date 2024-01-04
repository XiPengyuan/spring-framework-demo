package com.xipengyuan.demo.mybatisplus.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.xipengyuan.demo.mybatisplus.dal.enumeration.Grade;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 实体类无须继承{@link Model}。
 * <p>
 * 但继承Model抽象类可以开启ActiveRecord模式，此时{@link com.xipengyuan.demo.mybatisplus.dal.mapper.UserMapper}须存在并可用。
 * <p>
 * 参见测试类 UserEntityTest
 */
@TableName("tb_user")
@Getter
@Setter
@ToString
public class UserEntity extends Model<UserEntity> {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("user_num")
    private String number;

    private String name;

    private Integer age;

    private Grade grade;

    private String email;
}
