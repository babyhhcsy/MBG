package com.thero.framework.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * WebUtil 负责Cookie/Session等的管理。通常，所有对Cookie/Session的操作都通过此类来完成。 <br>
 * 
 * Session最终是采用 容器来管理，
 * 
 * @version 1.0
 */
public class WebUtil {
	/***
	 * Cookie约定的名称
	 */
	// PropertiesUtil propertiesUtil =
	// PropertiesUtil.createPropertiesUtil("sso.properties");
	public static String tokenPName = "Token";// propertiesUtil.getProperty("cookieTokenName");
	public static String uIdPName = "UID";// t_user.id
	public static String subUserIdPName = "SubUserId";// 如：employee.id ,
														// member.id等
	public static String userIdPName = "UserId";// t_user.userId==loginName
	public static String niceNamePName = "NiceName";// t_user.name
	public static int maxAge = 60 * 60;// Integer.valueOf(propertiesUtil.getProperty("cookieage"));
	public static String path = "/";
	
	//add thero 用于类型转换
	public static final String STR = "str";
	public static final String DATE = "date";
	public static final String JSON = "json";
	public static final String INTE = "lon";
	/**
	 * 根据名字从Session中获取一个对象
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @param name
	 *            Session中对象的名字
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObject(HttpServletRequest request, String name) {
		return (T) request.getSession().getAttribute(name);
	}

	/**
	 * 根据给定的name将一个对象保存到Session中
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @param name
	 *            Session中对象的名字
	 * @param object
	 *            需要保存到Session的对象
	 */
	public static <T> void putObject(HttpServletRequest request, String name,
			T object) {
		request.getSession().setAttribute(name, object);
	}

	/**
	 * 将Session置为无效状态，通常在注销时调用
	 * 
	 * @param request
	 *            HttpServletRequest
	 */
	public static void invalidateSession(HttpServletRequest request) {
		request.getSession().invalidate();
	}

	/**
	 * 将Session 去掉属性值
	 * 
	 * @param request
	 *            HttpServletRequest
	 */
	public static void removeSessionAttr(HttpServletRequest request, String name) {
		request.getSession().removeAttribute(name);
	}

	/**
	 * 获取URI的路径,如路径为http://www.example.com/example/user.do?method=add,
	 * 得到的值为"/example/user.do"
	 * 
	 * @param request
	 * @return String
	 */
	public static String getRequestURI(HttpServletRequest request) {
		return request.getRequestURI();
	}

	/**
	 * 获取不包含应用名字的URI的路径, 并去掉最前面的"/", <br>
	 * 如路径为http://localhost:8080/appName/user/list.do,
	 * 得到的值为"user/list.do",其中appNames为应用的名字
	 * 
	 * @param request
	 * @return String
	 */
	public static String getNoAppNamedRequestURI(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String realUri = uri.replace(contextPath, "");
		while (realUri.startsWith("/")) {
			realUri = realUri.substring(1);
		}
		realUri = realUri.replaceAll("/+", "/");
		return realUri;
	}

	/**
	 * 获取应用的根目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		if (contextPath.equals("/")) {
			return "";
		}
		return contextPath;
	}

	/**
	 * 获取完整请求路径(含内容路径及请求参数)
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestURIWithParam(HttpServletRequest request) {
		return getRequestURI(request)
				+ (request.getQueryString() == null ? "" : "?"
						+ request.getQueryString());
	}

	/**
	 * 获取处理用户连接,拦截器用
	 * 
	 * @param request
	 * @param url
	 * @return
	 */
	public static String getUrl(HttpServletRequest request, String url) {
		StringBuffer forword = new StringBuffer();
		StringBuffer beginUrl = new StringBuffer();
		StringBuffer backUrl = new StringBuffer();
		beginUrl.append(url);
		Map<String, String[]> paramMap = request.getParameterMap();
		if (paramMap != null) {
			for (String s : paramMap.keySet()) {
				String[] value = paramMap.get(s);
				for (String val : value) {
					backUrl.append(s).append("=").append(val).append("&");
				}
			}
		}
		forword.append(beginUrl);
		if (backUrl.length() > 0) {
			forword.append("?").append(backUrl);
		}
		if (forword.length() > 1) {
			if (forword.substring(forword.length() - 1, forword.length())
					.indexOf("&") > -1) {
				String.valueOf(forword.subSequence(0, forword.length() - 1));
			}
		}
		return String.valueOf(forword);
	}

    /** 
     * Title: 从request获取字符串<br/> 
     * Description: <br />
     * 
     * @author zzg16@163.com
     * @date 2014年7月30日 下午4:20:25
     * @param request
     * @param param
     * @return
     */
    public static String getString(HttpServletRequest request, String param) {
        try {
            String value=request.getParameter(param);
            if(StringUtils.isBlank(value)) {
                value=(String)request.getAttribute(param);
            }
            return value == null ? "" : value;
        } catch(Exception e) {
            return "";
        }
    }

    /** 
     * Title: 从request获取Long型数字<br/> 
     * Description: <br />
     * 
     * @author zzg16@163.com
     * @date 2014年7月30日 下午4:20:53
     * @param request
     * @param param
     * @return
     */
    public static Long getLong(HttpServletRequest request, String param) {
        String value=getString(request, param);
        if(StringUtils.isBlank(value) || !StringUtils.isNumeric(value)) {
            return null;
        }
        return Long.valueOf(value);
    }

    /** 
     * Title: 从request中获取int数字<br/> 
     * Description: <br />
     * 
     * @author zzg16@163.com
     * @date 2014年7月30日 下午4:21:03
     * @param request
     * @param param
     * @return
     */
    public static int getInt(HttpServletRequest request, String param) {
        Long value=getLong(request, param);
        if(value == null) {
            return 0;
        }
        return value.intValue();
    }
    /**
     * 功能描述：将字符串转换为map参数
     * 
     * 	注意
     * 		1、参数的格式是要放入到Map当中的key和其类型，并且以|相隔开
     * 		2、 如果时期是含有十分秒的话，需要将传递的参数中含有空格的字符转换为T
     * 			譬如：2014-12-03 16:43:00 转化为2014-12-03T16:43:00
     * 			这样做是为了日期在url传递的时候会自动的将空格转化为%20所以要做特殊处理
     * 	
     * @author tHero
     * @param request
     * @param paramName startDate_date|endDate_date|queryTimeType_str|queryExamType_str|
     * @return Map<String,Object>
     * @throws UnsupportedEncodingException 
     */
    public static Map<String,Object> detailParams(HttpServletRequest request,String paramName,Map<String,Object> paramMap,ModelMap map) {
    	if(null==paramMap){
    		paramMap = new HashMap<String,Object>();
    	}
    	if(StringUtils.isNotEmpty(paramName)){
    		//startDate_date
    		String[] params = paramName.split("\\|");
    		for(int i = 0 ;i < params.length;i++){
    			String key = (params[i].split("_"))[0];
    			String temp = params[i].substring(params[i].lastIndexOf("_")+1, params[i].length());
    			String value = request.getParameter(key);
    			//添加这个判断如果value为空，那么可以减少下面代码的执行次数
    			if(null==value){
    				paramMap.put(key, null);
    				continue;
    			}
    			if(StringUtils.isNotEmpty(temp)){
    				if(WebUtil.STR.equals(temp) ){
    					if(StringUtils.isNotEmpty(value) && StringUtils.length(value) > 0){
    						paramMap.put(key, WebUtil.getString(request, key));
    						map.put(key, WebUtil.getString(request, key));
    					}else{
    						paramMap.put(key, null);
    					}
    				}
    				if(WebUtil.DATE.equals(temp)){
    					if(StringUtils.isNotEmpty(value) && StringUtils.length(value)>0){
    						if(value.contains("T")){
    							paramMap.put(key, DateHelper.getFormatDate(value.replace("T", " ")));
    							map.put(key, WebUtil.getString(request, key));
    						}else{
    							paramMap.put(key, DateHelper.getDateByString(value));
    							
    						}
    					}else{
    						paramMap.put(key, null);
    					}
    					
    				}
    				if(WebUtil.INTE.equals(temp)){
    					paramMap.put(key, WebUtil.getInt(request, key));
    					map.put(key, WebUtil.getString(request, key));
    				}
    			}else{
    				throw new RuntimeException("第"+i+"个元素"+params[i]+"未指定其类型");
    			}
    		}
    	}else{
    		throw new RuntimeException("传入的参数为空");
    	}
    	return paramMap;
    		
    }
}
