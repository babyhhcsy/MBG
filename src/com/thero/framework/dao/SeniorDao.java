package com.thero.framework.dao;

import java.io.Serializable;

import com.thero.framework.common.CommonMapper;


public interface SeniorDao<T,PK extends Serializable>  extends BaseDao<T, PK>,CommonMapper<T, PK>{

}
