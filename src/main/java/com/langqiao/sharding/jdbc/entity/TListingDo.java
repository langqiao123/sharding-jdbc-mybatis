package com.langqiao.sharding.jdbc.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 框架自动生成表模型和CRUD操作，勿修改；
 * 如特殊需要，请以Ext***Mapper自行扩展；
 * 生成日期 : 2018-07-31 19:12:56
 * @author ##your name##
 */
@Setter
@Getter
@ToString
public class TListingDo {
    private Long id;

    private Long userId;

    private Integer listingId;

    private String desc;

    private BigDecimal amount;

    private Date inserttime;

    private Date updatetime;

    private Boolean isactive;
}