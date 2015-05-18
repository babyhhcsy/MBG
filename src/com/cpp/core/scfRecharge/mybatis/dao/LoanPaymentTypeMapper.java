package com.cpp.core.scfRecharge.mybatis.dao;

import com.cpp.core.common.entity.LoanPaymentType;
import com.cpp.core.common.entity.LoanPaymentTypeExample;
import com.thero.framework.common.CommonMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LoanPaymentTypeMapper extends CommonMapper<LoanPaymentTypeMapper, Long>{
    int countByExample(LoanPaymentTypeExample example);

    int deleteByExample(LoanPaymentTypeExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(LoanPaymentType record);

    int insertSelective(LoanPaymentType record);

    List<LoanPaymentType> selectByExample(LoanPaymentTypeExample example);

    LoanPaymentType selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") LoanPaymentType record, @Param("example") LoanPaymentTypeExample example);

    int updateByExample(@Param("record") LoanPaymentType record, @Param("example") LoanPaymentTypeExample example);

    int updateByPrimaryKeySelective(LoanPaymentType record);

    int updateByPrimaryKey(LoanPaymentType record);
}