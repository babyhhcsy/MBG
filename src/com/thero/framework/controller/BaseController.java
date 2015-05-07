package com.thero.framework.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;

import com.thero.framework.exception.GenericBusinessException;
import com.thero.framework.util.StringTool;


/**
 * Controller父类
 * 
 * @author cpp
 */
public abstract class BaseController {
	
	@Autowired
	public Properties coreConfiguration;

	public final static boolean IS_DEBUG = true;// 标识
	// 提示信息
	protected String msg;

	/** 是否是User用户 */
	protected boolean baseIsUser = true;
	
	/**
	 * 获取会员系统服务接口URL(总接口路径地址)
	 */
	protected @Value("#{coreConfiguration['ucenter.url']}") String ucenterUrl;
	
	/**
	 * AJAX 输出字符串
	 * 
	 * 
	 * @throws GenericBusinessException
	 * @throws IOException
	 */

	public String ajaxWriteStr(String jsonstr, HttpServletResponse response) throws GenericBusinessException {
		try {
			response.setContentType("text/html");// 这句设置很重要 对于其他支付方式对接
			// 苹果浏览器和IE下必须设置这个
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonstr);
		} catch (IOException e) {
			if (IS_DEBUG) {
				e.printStackTrace();
			}
			throw new GenericBusinessException("输出AJAX字符串出错！");
		}
		return null;
	}
	
	/**
	 * 
	 * 功能描述：将中文乱码转换成UTF-8
	 *
	 * @param value
	 * @return
	 * @throws GenericBusinessException
	 * 
	 * @author DongMM
	 *
	 * @since 2014-8-1
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	protected String toUTF8Coding(String value) throws GenericBusinessException {
		String newValue = "";
		try {
			if(StringUtils.isNotEmpty(value)){
				newValue = new String(value.getBytes("ISO-8859-1"),"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newValue;
	}
	
	/**
	 * 
	 * 功能描述：封装分页的URL(带参数)
	 *
	 * @param request  请求对象
	 * @param url	          提交的URL
	 * @param paramMap 参数
	 * @param flag 	         是否分页标记 true-是；false-否
	 * @return
	 * @throws GenericBusinessException
	 * 
	 * @author DongMM
	 *
	 * @since 2014-8-3
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	protected String toPageUrl(HttpServletRequest request, 
			String url,Map<String,Object> paramMap) throws GenericBusinessException {
		
		// 返回新的URL
		String newURL = request.getContextPath()+url+"?pageNo=pageNow";
		
		if(null != paramMap && paramMap.size() > 0){
			for(Map.Entry<String, Object> entry:paramMap.entrySet()){
				
				String value = entry.getValue()+"";
				if(StringTool.isNotEmpty(value)){
					newURL += "&"+entry.getKey()+"="+value;
				}
			}
		}
		return newURL;
	}
	
	/**
	 * 
	 * 功能描述：对分页中的中文参数进行转码
	 * 
	 * @param request
	 * @param name
	 * @return
	 * @throws GenericBusinessException
	 * 
	 * @author DongMM
	 *
	 * @since 2014-8-3
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	protected String toPageEconding(HttpServletRequest request,String name)throws GenericBusinessException {
		
		if(StringTool.isNotEmpty(name)){
			String mark = request.getParameter("mark");
			if("page".equals(mark)){
				return toUTF8Coding(name);
			}
		}
		return name;
	}
	
	/**
	 * 
	 * 功能描述：从cookie中获取当前系统用户名称
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws GenericBusinessException
	 * 
	 * @author DongMM
	 *
	 * @since 2014-8-11
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	protected String getUserName(HttpServletRequest request,HttpServletResponse response) throws GenericBusinessException {
		
		String userName =request.getAttribute("username")+"";
		//System.err.println("当前系统登陆用户："+userName);
		return null == userName ? "" : userName;
	}
	
	public boolean isBaseIsUser() {
		return baseIsUser;
	}

	public void setBaseIsUser(boolean baseIsUser) {
		this.baseIsUser = baseIsUser;
	}

	/**
	 * 获取会员系统的根据“会员名”模糊查询所有会员的请求URL
	 */
	protected String getUcenterAllUrl() {
		return ucenterUrl+"/user/allUser";
	}
	
	/**
	 * 获取会员系统的根据“会员名”查询会员对象的请求URL
	 */
	protected String getUcenterGetUrl() {
		return ucenterUrl+"/user/getUserByUserName";
	}

	/**
	 * 获取会员系统的根据“会员名”修改会员对象的请求URL
	 */
	protected String getUcenterEditUrl() {
		return ucenterUrl+"/user/updateUser";
	}

	/**
	 * 获取保存资金流水的请求URL
	 */
	protected String getUserdaybookSaveDayUrl() {
		return ucenterUrl+"/daybook/saveDayBook";
	}
	
	/**
	 * 获取判断会员名是否存的请求URL
	 */
	protected String getUcenterIsExitUrl() {
		return ucenterUrl+"/user/isExitUser";
	}
	
	/**
     * 
     * 功能描述：对直辖市进行处理，避免出现产地值为北京市北京市的情况
     *
     * @return
     * @throws DataAccessException
     * 
     * @author ShiWJ
     *
     * @since 2014-9-10
     *
     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
    public String city(String province, String city)throws DataAccessException{
    	return province + "," + city;
    }
    
}
