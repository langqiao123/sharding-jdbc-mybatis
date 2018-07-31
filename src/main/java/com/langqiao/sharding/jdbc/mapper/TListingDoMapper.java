package com.langqiao.sharding.jdbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.langqiao.sharding.jdbc.entity.TListingDo;

/**
 * 框架自动生成表模型和CRUD操作，勿修改；
 * 如特殊需要，请以Ext***Mapper自行扩展；
 * 生成日期 : 2018-07-31 19:12:56
 * @author ##your name##
 */
@Repository
public interface TListingDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TListingDo record);

    int insertSelective(TListingDo record);

    TListingDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TListingDo record);

    int updateByPrimaryKey(TListingDo record);

    /**
     * 通用查询行数方法，可设置查询属性
     */
    Long selectCountSelective(@Param("record") TListingDo record);

    /**
     * 通用查询List方法，可设置查询属性，排序字段，分页参数 
     */
    List<TListingDo> selectPageSelective(@Param("record") TListingDo record, @Param("pageable") Pageable pageable);

    /**
     * 批量逻辑删除,set is_deleted=1返回影响行数
     */
    Integer batchDeleteByPrimaryKey(List<Long> pkIds);

    /**
     * 插入行记录返回自增ID
     */
    Integer insertSelectiveReturnPrimaryKey(TListingDo record);

    /**
     * 批量插入行数据返回插入行数
     */
    Integer batchInsert(List<TListingDo> records);

    /**
     * 根据主键批量获取
     */
    List<TListingDo> batchSelectByPrimaryKey(List<Long> pkIds);
}