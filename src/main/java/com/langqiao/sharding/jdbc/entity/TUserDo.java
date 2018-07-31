package com.langqiao.sharding.jdbc.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 框架自动生成表模型和CRUD操作，勿修改；
 * 如特殊需要，请以Ext***Mapper自行扩展；
 * 生成日期 : 2018-07-31 19:55:15
 * @author ##your name##
 */
@Setter
@Getter
@ToString
public class TUserDo {
    private Long id;

    private Long userId;

    private String name;

    private Integer age;

    private Date inserttime;

    private Date updatetime;

    private Boolean isactive;
}