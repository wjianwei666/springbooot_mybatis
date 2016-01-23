/**  
 * @Title: BaseMapper.java
 * @Package com.sean.commons.mapper
 * @Description:  公共Mapper 接口
 * @author Wang Jianwei
 * @date 2016-1-22
 */
package com.sean.commons.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * 公共Mapper 接口
 * 
 * ClassName: BaseMapper
 * @Description: 公共Mapper 接口
 * @author  Wang Jianwei
 * @date 2016-1-22
 */
public interface BaseMapper <T extends Serializable ,E, ID extends Serializable> {

    int countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
