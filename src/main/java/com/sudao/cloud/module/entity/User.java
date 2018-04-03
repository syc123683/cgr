package com.sudao.cloud.module.entity;

import com.sudao.cloud.module.entity.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Spector on 2017/6/1.
 */
public class User extends BaseEntity {
    private Long userId;
    private String name;
    private Integer age;
    private Date birthday;
    private Long firstName;
    private String lastName;
    private BigDecimal money;

    private String attr1;
    private String attr2;
    private BigDecimal attr4;


}
