package com.thero.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.thero.framework.common.Pager;





/**
 * Created by IntelliJ IDEA.
 *
 * @author Yan
 * @version 1.0
 * @CreationTime: 13-2-23 下午4:15
 * @Description:
 */
public interface BaseService <T, PK extends Serializable> {

    /**
     * 保存对象
     * @param o
     * @return
     */
    void save(T o) ;

    /**
     * 删除对象记录
     * @param id
     */
    void delete(PK id) ;

    /**
     * 通过ID查询对象
     * @param id
     * @return
     */
    T getByID(PK id);

    /**
     * 跟新对象
     * @param model
     */
    void update(T model);

    /**
     * 统计数据总条数
     * @return
     */
    int countAll();

    /**
     * 获取全部对象
     * @return
     */
    List<T> findAll();

    /**
     *  查询所有的ID集合
     * @return
     */
    List<PK> findAllIds();

    /**
     *  根据此查询条件统计记录总条数
     * @param parameters map 包含各种属性的查询
     * @return
     */
    Integer findNumberByCondition(Map<String, Object> parameters);

    /**
     * 分页查询函数，返回对象集合
     * @param parameters map 包含各种属性的查询
     * @param rowBounds 偏移量恢复为初始值(offet:0,limit:Integer.max) 使用参考：new RowBounds(pageNum, pageSize)
     * @return
     */
    List<T> findPageBreakByCondition(Map<String, Object> parameters,int offset, int pageSize);

    
    /**
     * 分页查询函数，返回对象集合
     * @param parameters map 包含各种属性的查询
     * @param pageNo 当前页码
     * @param pageSize 每页记录数
     * 
     * @return
     */
    Pager<T> findPageByCondition(Map<String, Object> parameters,int pageNo, int pageSize) ;
    
    /**
     * 循环删除ids
     * @param ids
     * @param param
     * @
     */
    Map<String,Object> deleteIds(String ids,Map<String,Object> param) ;
}
