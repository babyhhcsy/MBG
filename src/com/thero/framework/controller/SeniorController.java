package com.thero.framework.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thero.framework.common.Pager;
import com.thero.framework.exception.CharIsNullException;
import com.thero.framework.service.BaseService;
import com.thero.framework.service.SeniorService;
import com.thero.framework.util.JsonMap;
import com.thero.framework.util.PageParamsUtil;
import com.thero.framework.util.StringUtil;
import com.thero.framework.util.WebUtil;

/**
 * 高级Controller，用于处理通用的查询方式；包含增删查改等相关内容
 * @author thero
 * @param <T> 实体bean
 * @param <PK> 主键
 */
/**
 * @author babycsy
 *
 * @param <T>
 * @param <PK>
 */
public abstract class SeniorController<T,PK extends Serializable> extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(SeniorController.class);
	/**
	 * 分页查询使用的参数
	 */
	private ThreadLocal<HashMap<String,Object>> beforeQueryByBeanParams =  new ThreadLocal<HashMap<String,Object>>(){
		
		@Override
		public void set(HashMap<String, Object> value) {
			super.set(value);
		}

		@Override
		protected HashMap<String, Object> initialValue() {
			return new HashMap<String,Object>();
		}
	}; 
	/**
	 * 查询完成后结果集map
	 */
	private ThreadLocal<Map<String,Object>> queryResultMap = new ThreadLocal<Map<String,Object>>(){
		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String,Object>();
		}
	};
	/**
	 * paramName 获取参数的格式：示例：methodCode_str|APPID_str|key_str|pageNum_lon|pageSize_lon
	 */
	protected String paramName;
	
	/**
	 * 查询统一使用的参数内容
	 */
	private ThreadLocal<Map<String,Object>> params = new ThreadLocal<Map<String,Object>>(){
		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String,Object>();
		}
		
	};
	/**
	 * 查询结果使用的结果集
	 * */
	private ThreadLocal<Map<String,Object>> resultMap = new ThreadLocal<Map<String,Object>>(){
		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String,Object>();
		}
		
	};
	
	private ThreadLocal<List<String>> result = new ThreadLocal<List<String>>(){
		@Override
		protected List<String> initialValue() {
			return new ArrayList<String>();
		}
		
	};
	
	public  final String URL = "url";
	public  final String TYPE = "interface";
	/**
	 * 查询完成后返回的地址，需要将其放置的this.params中
	 * */
	public  final String RESULT_URL = "resultUrl";
	
	/**
	 * 删除后返回的地址，需要将其放置的this.params中
	 */
	public  final String DELETE_URL = "deleteUrl";
	/**
	 * SAVERESULTURL保存成功执行的路径
	 */
	public  final String SAVERESULTURL = "saveResultUrl";
	/**
	 * UPDATERESULTURL 更新成功后执行的路径
	 */
	public  final String UPDATERESULTURL = "updateResultUrl";
	
	/**
	 * AFTER_UPDATE_URL在更新实力类之前，调转要修改的url地址路径
	 */
	public final String  AFTER_UPDATE_URL = "afterUpdateUrl";
	protected  SeniorService<T, PK> getService(){
		return (SeniorService<T, PK>) getEntityService();
	};
	/**
	 * 重写该方法的时候，需要返回的是继承SeniorService，这样在使用getService的时候
	 * 不会报错
	 * @return
	 */
	protected  abstract BaseService<T, PK> getEntityService();
	
	
	/**
	 * 获得bean的modelAttribute
	 * 在通过查询该id的时候，如果没有查询到那么会返回为null值，在处理的时候需要处理该问题
	 * @param pk
	 * @param map
	 * @return 
	 */
	public  T getBean(@RequestParam(value="fid",required=false) PK id,Map<String,Object> map){
		if(null!=id){
			//T t = this.getEntityService().getByID((PK) id);
			//使用自动生成的文件去保存内容
			T t = this.getService().selectByPrimaryKey(id);
			map.put(this.getModelName(), t);
			return t;
		}
		return null;
	}
	//---------------------------------------------web端使用的方法-------------------------------------------------------------
	
	/**
	 * 保存实体bean
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 */
	public void saveEntity(T t,ModelMap map,HttpServletRequest request,HttpServletResponse response ){
		this.beforeSaveEntity(t, map, request, response);
		//使用自动生成的文件去保存内容
		this.getService().insert(t);
		//this.getEntityService().save(t);
	}
	/**
	 * 更新实体bean
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 */
	public void updateEntity(T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		this.beforeUpdateEntity(t, map, request, response);
		//使用自动生成的文件去保存内容
		//this.getEntityService().update(t);
		this.getService().updateByPrimaryKey(t);
	}
	/**
	 * web使用的保存示例内容
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/saveEntity")
	public String saveModel(T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		this.beforeSaveEntity(t, map, request, response);
		this.saveEntity(t, map, request, response);
		return this.afterSaveEntity();
	}
	/**
	 * web使用的更新接口对象
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateEntity")
	public String updateModel(@RequestParam(value="fid") PK id,T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		T temp = getBean(id,map);
		BeanUtils.copyProperties(t, temp);
		this.updateEntity(t, map, request, response);
		return this.afterUpdateEntity();
	}
	/**
	 * 查询单个实体详情内容
	 * @param id
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deatilEntity")
	public String EntityDetail(@RequestParam(value="fid") PK id,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		//T t = this.getBean(id, map);
		//使用自动生成的文件去保存内容
		T t = this.getService().selectByPrimaryKey(id);
		map.put(this.getModelName(), t);
		logger.info("查询单个实体的返回路径为" + this.getModelName() + "/"+this.getModelName()+"Detail");
		return this.getModelName()+"/"+this.getModelName()+"Deatil";
	}
	/**
	 * @param map
	 * 	resultUrl 查询完成后返回的页面时什么，如果不填写，请重写afterQueryByBean该方法；
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/pageQueryByBean")
	public String nomarlPageQueryByBean(ModelMap map,HttpServletRequest request,HttpServletResponse response ) throws Exception{
		this.pageQueryByBean(map, request, response);
		return this.afterQueryByBean(map);
	}
	
	//---------------------------------------------公共方法-------------------------------------------------------------
	/**
	 * 执行分页查询
	 * @param map
	 * 	 paramName 获取参数的格式：示例：methodCode_str|APPID_str|key_str|pageNum_lon|pageSize_lon
	 *   * url :分页点击下一样使用到的参数 page.setUrl(this.toPageUrl(request, beforeQueryByBeanParams.get("url").toString()+"/pageQueryByBean", beforeQueryByBeanParams));
	 *   resultUrl 查询完成后返回的页面时什么，如果不填写，请重写afterQueryByBean该方法；
	 *   type 表示是接口还是普通的查询模式
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void pageQueryByBean(ModelMap map,HttpServletRequest request,HttpServletResponse response )throws Exception{
		this.beforeQueryByBeanParams.set(new HashMap<String,Object>());
		queryResultMap.set(new HashMap<String,Object>());
		//初始化参数处理
		this.beforeQueryByBean(this.beforeQueryByBeanParams.get(),map,request,response);
		//将参数转换为Map
		WebUtil.detailParams(request, this.paramName,this.beforeQueryByBeanParams.get(),map);
		//分页参数的初始化内容
		PageParamsUtil pageParamsUtil = PageParamsUtil.getPageParams(request);
		//查询
		Pager<T> page = this.getEntityService().findPageByCondition(beforeQueryByBeanParams.get(), pageParamsUtil.getPageNo(), pageParamsUtil.getPageSize());
		/*if(null==beforeQueryByBeanParams.get("url")){
			throw new RuntimeException("在beforeQueryByBean方法中没用配置url参数，用于分页查询跳转参数");
		}*/
		page.setUrl(this.toPageUrl(request, "/"+this.getModelName()+"/pageQueryByBean", beforeQueryByBeanParams.get()));
		map.put("pager",page);
		//将结果集赋值到成员变量中
		queryResultMap.get().putAll(map); 
	}
	/**
	 * 更新实体做的参数处理对象
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 */
	protected void beforeUpdateEntity(T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){}
	/**
	 * 保存实体做的参数处理
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 */
	protected void beforeSaveEntity(T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){}
	/**
	 * 更新实体对象后，保存返回的路径，配置this.UPDATERESULTURL即可
	 * @return
	 */
	protected String afterUpdateEntity(){
		if(null!=this.getParams().get(this.UPDATERESULTURL)){
			logger.info("用户配置的更新的url为："+this.getParams().get(this.UPDATERESULTURL));
			return this.getParams().get(this.UPDATERESULTURL).toString();
		}
		logger.info("系统默认的跳转路径为："+"redirect:/"+this.getModelName()+"/pageQueryByBean" );
		return "redirect:/"+this.getModelName()+"/pageQueryByBean";
	}
	/**
	 * 保存实体后做的处理
	 * 如果在beforeSaveEntity中配置了SAVERESULTURL的常量，那么他会按照配置的信息进行跳转
	 * 否则：返回的内容为该实体类的查询内容url为：redirect:/+实体类名称+pageQueryByBean
	 * @return
	 */
	protected String afterSaveEntity(){
		if(null!=this.getParams().get(this.params.get().get(this.SAVERESULTURL))){
			logger.info("保存后用户配置的url跳转路径为"+"redirect:/"+this.getParams().get(this.SAVERESULTURL));
			return "redirect:/"+this.getParams().get(this.SAVERESULTURL).toString();
		}
		logger.info("系统默认的跳转路径为："+"redirect:/"+this.getModelName()+"/pageQueryByBean" );
		return "redirect:/"+this.getModelName()+"/pageQueryByBean";
	}
	/**
	 * 在分页查询执行，用来处理参数等相关信息
	 * @param params
	 * 
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	public Map<String,Object> beforeQueryByBean(Map<String,Object> params,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		return this.beforeQueryByBeanParams.get();
	}
	/**
	 * 分页查询结束后跳转的url
	 * @param params
	 * @return
	 */
	public String afterQueryByBean(Map<String,Object> params){
		if(null!=this.beforeQueryByBeanParams.get().get(this.RESULT_URL)){
			logger.info("分页查询跳转url的路径为"+this.beforeQueryByBeanParams.get().get(this.RESULT_URL));
			return this.beforeQueryByBeanParams.get().get(this.RESULT_URL).toString();
		}
		logger.info("系统默认的路径为："+this.getModelName()+"/"+this.getModelName()+"List");
		return this.getModelName()+"/"+this.getModelName()+"List";
	}
	/**
	 * 删除一个实体bean对象
	 * 参数：
	 * 	* id 必须
	 * 返回值：
	 * 	error ：删除对象不存在；
	 * 	succful：删除成功
	 * @param id
	 * @param map
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteEntity")
	public String deleteEntity(@RequestParam(value="fid",required=false)PK id,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		this.beforeDeleteEntity(id, map, request, response);
		logger.info("系统要删除的id为"+id);
		T t = getBean(id, map); 
		if(null==t){
			map.put("error", "删除的对象不存在");
		}else{
			this.getEntityService().delete(id);
			map.put("succful", "删除成功");
		}
		return this.afterDeleteEntity(map, request, response);
	}
	/**
	 * 删除前操作内容
	 * @param id 删除id
	 * @param map 作用域对象
	 * @param request
	 * @param response
	 */
	public void beforeDeleteEntity(PK id,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		
	}
	/**
	 * 删除对象后操作方法；
	 * 
	 * @param t 要删除的实体对象bean
	 * @param id 删除的id是什么
	 * @param map
	 * @param request
	 * @param response
	 */
	public String afterDeleteEntity(ModelMap map,HttpServletRequest request,HttpServletResponse response){
		if(null!=this.params.get().get(this.DELETE_URL)){
			logger.info("删除返回的路径为--用户配置的路径"+"redirect:/"+this.params.get().get(this.DELETE_URL));
			return "redirect:/"+this.params.get().get(this.DELETE_URL);
		}
		logger.info("框架默认的路径为："+"redirect:/"+this.getModelName()+"/"+"pageQueryByBean");
		return "redirect:/"+this.getModelName()+"/"+"pageQueryByBean";
	}
	/**
	 * 接口使用删除单个实体方法；
	 * 	参数:
	 * 		* id 查询实体id
	 * 	返回值：
	 * 		成功 
	 * 			succful 删除成功；
	 * 		失败：
	 * 			fail 删除失败
	 * @param id
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteModel")
	public Map<String,Object> deleteEntityFromInt(@RequestParam(value="fid",required=false)PK id,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		this.resultMap.set(new HashMap<String,Object>());
		T t = getBean(id, map);
		if(null==t){
			this.resultMap.get().put("error", "删除的对象不存在");
		}else{
			this.getEntityService().delete(id);
			this.resultMap.get().put("succful", "删除成功");
		}
		return this.resultMap.get();
	}
	/**
	 * 删除多个实体对象；
	 * @param ids
	 * @param map
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteEntities")
	public String deleteEntities(ModelMap map,HttpServletRequest request,HttpServletResponse response){
		this.params.set(new HashMap<String,Object>());
		String fids = request.getParameter("fids");
		logger.info("****系统要删除的ids的集合为****"+ fids);
		this.beforeDeleteEntities(fids, map, request, response);
		Map<String,Object> param  = WebUtil.detailParams(request, fids, this.params.get(),map);
		if(null!=fids && fids.length() > 0){
			//this.resultMap.get().putAll(this.getEntityService().deleteIds(fids, param));
			////使用自动生成的文件去保存内容
			this.resultMap.get().putAll(this.getService().deleteIds(fids,param));
		}
		map.putAll(this.resultMap.get());
		return this.afterDeleteEntity(map, request, response);
	}
	public void beforeDeleteEntities(String ids,ModelMap map,HttpServletRequest request,HttpServletResponse response){}
	/**
	 * 接口使用
	 * 	参数：
	 * 	  * ids 参数为ids 使用分号相隔
	 * 	返回值：
	 * 		成功 
	 * 			succful 删除成功；
	 * 		失败：
	 * 			fail 删除失败
	 * @param ids
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteModels")
	public Map<String,Object> deleteModels(String ids,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		params.set(new HashMap<String,Object>());
		Map<String,Object> param  = WebUtil.detailParams(request, ids, this.params.get(),map);
		if(null!=ids && ids.length() > 0){
			////使用自动生成的文件去保存内容
			this.resultMap.get().putAll(this.getService().deleteIds(ids,param));
		}
		return this.resultMap.get();
	}
	
//---------------------------------------------接口使用的内容-------------------------------------------------------------
	/**
	 * 返回json格式的查询，并且可以按照分页进行查询
	 * @param params 
	 * 	 paramName 获取参数的格式：示例：methodCode_str|APPID_str|key_str|pageNum_lon|pageSize_lon
	 *   * url :分页点击下一样使用到的参数 page.setUrl(this.toPageUrl(request, beforeQueryByBeanParams.get("url").toString()+"/pageQueryByBean", beforeQueryByBeanParams));
	 *   resultUrl 查询完成后返回的页面时什么，如果不填写，请重写afterQueryByBean该方法；
	 * @param map
	 * @param request
	 * @param response
	 * @return josn数组
	 */
	@ResponseBody
	@RequestMapping(value="/getEntityList")
	public Map<String,Object> getEntityList(Map<String, Object> params,
			ModelMap map, HttpServletRequest request,
			HttpServletResponse response){
		resultMap.set(new HashMap<String,Object>());
		Map<String,Object> temp = this.resultMap.get();
		try {
			this.pageQueryByBean(map, request, response);
			Map<String,Object> QueryResult  = this.getQueryResultMap();
			temp = new JsonMap(1, "");
			this.resultMap.get().put("result", QueryResult);
			//{result={pager=com.cpp.core.common.utils.Pager@dfa1ed}, flag=1, flagmsg=}
			this.afterQueryByBeanFromInterface(this.resultMap.get());
		} catch (CharIsNullException e) {
			temp = new JsonMap(2, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			temp = new JsonMap(-1, "系统异常");
			e.printStackTrace();
		}
		this.resultMap.get().putAll(temp);
		return this.resultMap.get();
	}
	/**
	 * 接口保存示例对象
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveModel")
	public Map<String,Object> saveModelFormInterface(T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		resultMap.set(new HashMap<String,Object>());
		Map<String,Object> temp = this.resultMap.get();
		try {
			//保存操作
			this.saveEntity(t, map, request, response);
			temp = new JsonMap(1, "");
			this.resultMap.get().put(t.getClass().getName(), t);
			//this.setResultMap(map);
			//putParam2RsultMap(map, request, response);
			this.afterModelSave(this.getResultMap());
		} catch (CharIsNullException e) {
			temp = new JsonMap(2, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			temp = new JsonMap(-1, "系统异常");
			e.printStackTrace();
		}
		this.resultMap.get().putAll(temp);
		return this.getResultMap();
	}
	/**
	 * 更新实体对象--接口中使用
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateModel")
	public Map<String,Object> updateModelFromInterface(@RequestParam(value="fid" ,required=false ) PK id,T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		resultMap.set(new HashMap<String,Object>());
		Map<String,Object> temp1 = this.resultMap.get();
		try {
			//数据库中对象
			T temp = getBean(id, map);
			//拷贝对象属性
			BeanUtils.copyProperties(t, temp);
			//保存操作
			this.updateEntity(t, map, request, response);
			
			temp1 = new JsonMap(1, "");
			this.resultMap.get().put(t.getClass().getName(), t);
			
			//this.setResultMap(map);
			//putParam2RsultMap(map, request, response);
			this.afterModelUpdate(map);
		}  catch (CharIsNullException e) {
			temp1 = new JsonMap(2, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			temp1 = new JsonMap(-1, "系统异常");
			e.printStackTrace();
		}
		this.resultMap.get().putAll(temp1);
		return this.getResultMap();
	}
	/**
	 * 将参数放置到result结果集中，用于afterModelSave使用
	 * */
	private  void putParam2RsultMap(ModelMap map,HttpServletRequest request,HttpServletResponse response){
		
		Map<String,Object> temp = this.getResultMap();
		if(null==temp){
			throw new RuntimeException("putParam2RsultMap方法：查询或者保存的结果集为空，无法操作——");
		}else{
			this.resultMap.get().put("request", request);
			this.resultMap.get().put("response", response);
			this.resultMap.get().put("map", map);
		}
	}
	/**
	 * 接口使用的保存对象后的处理内容
	 * @param map
	 * @return
	 */
	public Map<String,Object> afterModelSave(Map<String,Object> map){
		return map;
	}
	/**
	 * 接口使用的更新对象后的内容
	 * @param map
	 * @return
	 */
	public Map<String,Object> afterModelUpdate(Map<String,Object> map){
		return map;
	}
	/**
	 * 在保存用户对象前用于url的跳转；使用该方法必须Controller的C大写
	 * @param t 
	 * @param map
	 * @param request
	 * @param response
	 * @return 页面的地址；注意，添加的页面为实体bean名称（文件夹）+ add + 实体类的名称如
	 * addClientInfo  addEntAdv
	 */
	@RequestMapping("/beforeAdd")
	public String beforeAddTurnURL(T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getModelName()+"/add"+this.getModelName());
		return this.getModelName()+"/add"+StringUtil.toUpperCaseFirstOne(this.getModelName());
	}
	/**
	 * 接口使用方法，根据id查询内容；
	 * 	参数
	 * 	* id: 必须
	 * 	 返回值：
	 * 		查询成功；
	 * 			t  实体类对象；
	 * 		查询失败
	 * 			error 无法查询该对象；
	 * @param id
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/beforeUpdateInt")
	public Map<String,Object> beforeUpdateURLFromInt(@RequestParam(value="fid",required=false)PK id, ModelMap map,HttpServletRequest request,HttpServletResponse response){
		T t  = getBean(id, map);
		if(null==t){
			this.resultMap.get().put("error", "无法查询该对象");
		}else{
			this.resultMap.get().put(this.getModelName(), t);
		}
		return this.resultMap.get();
	}
	/**
	 * 更新实体类使用方法；
	 * 	参数：
	 * 		* id 必须
	 * 	返回值：
	 * 		成功：map对象中有该实体对象，（key）名称为实体类首字母小写内容；
	 * 		失败：实体对象为空
	 * @param id
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/beforeUpdate")
	public String beforeUpdateTurnURL(@RequestParam(value="fid" ,required=false )PK id ,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		T t = getBean(id, map);
		this.beforeUpdateEntity(t, map, request, response);
		String name = this.getModelName();
		map.put(name, t);
		return this.afterUpdateTurnURL(t, map, request, response);
	}
	/**
	 * 在修改实体类前的操作步骤
	 * @param t
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	public String afterUpdateTurnURL(T t,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		if(null!=this.params.get().get(this.AFTER_UPDATE_URL)){
			logger.info("在查询到实体后，要返回的url"
					+ "的地址为："+this.params.get().get(this.AFTER_UPDATE_URL).toString());
			return this.params.get().get(this.AFTER_UPDATE_URL).toString();
		}
		logger.info("在查询实体后，要返回的url地址为："+this.getModelName()+"/"+"edit"+StringUtil.toUpperCaseFirstOne(this.getModelName()));
		return this.getModelName()+"/"+"edit"+StringUtil.toUpperCaseFirstOne(this.getModelName());
	}
	private String getModelName(){
		String[] names = this.getClass().getName().split("\\.");
		String name = names[names.length-1];
		return StringUtil.toLowerCaseFirstOne(name.replace("Controller", ""));
	}
	/**
	 * 查询完成后执行的方法；用于查询完成后的数据处理
	 * @param params
	 * 	result ：查询对应的结果集，是个Map集合
	 * 		pager.list 查询的结果集
	 * 		
	 * @return
	 */
	public Map<String,Object> afterQueryByBeanFromInterface(Map<String,Object> params){
		return params;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public Map<String, Object> getQueryResultMap() {
		return queryResultMap.get();
	}

	public Map<String, Object> getParams() {
		return params.get();
	}
	public Map<String, Object> getResultMap() {
		return resultMap.get();
	}

	public HashMap<String, Object> getBeforeQueryByBeanParams() {
		return this.beforeQueryByBeanParams.get();
	}
}
