package com.thero.mapper.common;

import java.util.ArrayList;
import java.util.List;




public class GeneratedCriteria {
	 public List<Criterion> criteria;

     public GeneratedCriteria() {
         super();
         criteria = new ArrayList<Criterion>();
     }

     public boolean isValid() {
         return criteria.size() > 0;
     }

     public List<Criterion> getAllCriteria() {
         return criteria;
     }

     public List<Criterion> getCriteria() {
         return criteria;
     }

     public void addCriterion(String condition) {
         if (condition == null) {
             throw new RuntimeException("Value for condition cannot be null");
         }
         criteria.add(new Criterion(condition));
     }

     public void addCriterion(String condition, Object value, String property) {
         if (value == null) {
             throw new RuntimeException("Value for " + property + " cannot be null");
         }
         criteria.add(new Criterion(condition, value));
     }

     public void addCriterion(String condition, Object value1, Object value2, String property) {
         if (value1 == null || value2 == null) {
             throw new RuntimeException("Between values for " + property + " cannot be null");
         }
         criteria.add(new Criterion(condition, value1, value2));
     }
     /**
      * 判断该字段为空
     * @param column 字段名称
     * @author thero
     * @return
     */
    public Criteria andIsNull(String column){
    	 addCriterion(" "+column + " is null ");
    	 return (Criteria) this;
     }
     /**
      * 判断字段不为空
     * @param column 字段名称
     * @return
     */
    public Criteria andIsNotNull(String column){
    	 addCriterion(" "+ column + " is not null ");
    	 return (Criteria) this;
     }
   
     /**
      * 判断字段等于
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andEqualTo(String column,Object value,String property){
    	 addCriterion(" "+ column + " = " , value ,property);
    	 return (Criteria) this;
     }
    /**
     * 判断字段不等于
     * @param column  字段名称
     * @param value   数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andNotEqualTo(String column,Object value,String property){
    	addCriterion(" "+column+" <> ", value, property);
    	 return (Criteria) this;
    }
    /**
     * 判断字段大于
     * @param column 字段名称
     * @param value 数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andGreaterThan(String column,Object value,String property) {
    	addCriterion(" "+column+" > ", value, property);
    	 return (Criteria) this;
    }
    /**
     * 判断字段大于等于
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andGreaterThanOrEqualTo(String column,Object value,String property) {
    	addCriterion(" "+column+" >= ", value, property);
   	 	return (Criteria) this;
    }
    /**
     * 判断字段小于
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andLessThan(String column,Object value,String property) {
    	addCriterion(" "+column+" < ", value, property);
   	 	return (Criteria) this;
    }
    /**
     * 判断字段小于等于
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andLessThanOrEqualTo(String column,Object value,String property) {
    	addCriterion(" "+column+" <= ", value, property);
   	 	return (Criteria) this;
    }
    /**
     * 判断字段在某个范围in
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andIn(String column,List<Object> values,String property){
    	  addCriterion(" "+column +" in ", values, property);
          return (Criteria) this;
    }
    /**
     * 判断字段不在某个范围in
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andNotIn(String column,List<Object> values,String property){
    	  addCriterion(" "+column +" not in ", values, property);
          return (Criteria) this;
    }
    /**
     * 判断字段在什么之间
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andBetween(String column,Object value1,Object value2,String property){
    	  addCriterion(" "+column +" between ", value1, value2,property);
          return (Criteria) this;
    }
    /**
     * 判断字段不在什么之间
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andNotBetween(String column,Object value1,Object value2,String property){
    	  addCriterion(" "+column +" between ", value1, value2,property);
          return (Criteria) this;
    }
    /**
     * 类似于
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andLike(String column,Object value,String property){
    	addCriterion(" "+ column + " like", value, property);
    	return (Criteria) this;
    }
    /**
     * 不类似于
     * @param column 字段名称
     * @param value  数值
     * @param property 类属性名称
     * @return
     */
    public Criteria andNotLike(String column,Object value,String property){
    	addCriterion(" "+ column + " not like", value, property);
    	return (Criteria) this;
    }
    
}