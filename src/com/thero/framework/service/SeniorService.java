package com.thero.framework.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thero.framework.common.CommonExample;


public interface SeniorService<T,PK extends Serializable> {
	int countByExample(CommonExample example);

    int deleteByExample(CommonExample example);

    int deleteByPrimaryKey(PK pk);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(CommonExample example);

    T selectByPrimaryKey(PK pk);

    int updateByExampleSelective(@Param("record") T record, @Param("example") CommonExample example);

    int updateByExample(@Param("record") T record, @Param("example") CommonExample example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
