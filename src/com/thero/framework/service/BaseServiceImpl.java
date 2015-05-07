package com.thero.framework.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thero.framework.common.Pager;
import com.thero.framework.dao.BaseDao;

/**
 * Created by IntelliJ IDEA.
 * 
 * @author Yan
 * @version 1.0
 * @CreationTime: 13-2-23 下午4:19
 * @Description:
 */
public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    protected abstract BaseDao<T, PK> getDao();

	public void save(T o)  {
		
		//判断对象是否为空  yzp 2013年3月27日9:57:19
		
		this.getDao().save(o);
	}

	
	public void delete(PK id)  {
		
		//判断编号是否为空  yzp 2013年3月27日9:57:19
		
		this.getDao().delete(id);
	}


	public T getByID(PK id)  {
		
		//判断编号是否为空  yzp 2013年3月27日9:57:19

		return this.getDao().getByID(id);
	}

	
	public void update(T model)  {
		
		//判断对象是否为空  yzp 2013年3月27日9:57:19

		
		this.getDao().update(model);
	}


	public int countAll()  {
		return this.getDao().countAll();
	}


	public List<T> findAll()  {
		return this.getDao().findAll();
	}


	public List<PK> findAllIds() {
		return this.getDao().findAllIds();
	}


	public Integer findNumberByCondition(Map<String, Object> parameters)  {
		//判断对象是否为空  yzp 2013年3月27日9:57:19
		return this.getDao().findNumberByCondition(parameters);
	}


	public List<T> findPageBreakByCondition(Map<String, Object> parameters, int offset, int pageSize)  {
		//判断对象是否为空  yzp 2013年3月27日9:57:19
		return this.getDao().findPageBreakByCondition(parameters, new RowBounds(offset, pageSize));
	}

	/**
     * 分页查询函数，返回对象集合
     * @param parameters map 包含各种属性的查询
     * @param pageNo 当前页码
     * @param pageSize 每页记录数
     * 
     * @return
     */
	@Override
	public Pager<T> findPageByCondition(Map<String,Object> parameters,int pageNo,int pageSize)  {
	    
		int totalCount = this.getDao().findNumberByCondition(parameters);
	    Pager<T> pager = new Pager<T>(pageNo, pageSize);
	    pager.setTotalCount(totalCount);
	    List<T> items = this.getDao().findPageBreakByCondition(parameters, new RowBounds(pager.getStartIndex(), pageSize));
	    pager.setList(items);
	    return pager;
	}

	@Override
	public Map<String,Object> deleteIds(String ids, Map<String, Object> param)
			 {
		Map<String,Object> map = new HashMap<String,Object>();
		if(null!=ids && ids.length() > 0){
			String[] idss = ids.toString().split(";");
			for(int i = 0 ;i < idss.length;i++){
				this.delete((PK) idss[i]);
			}
			map.put("succful", "删除成功");
		}else{
			map.put("fail", "删除失败");
		}
		return map;
	}
	
}
