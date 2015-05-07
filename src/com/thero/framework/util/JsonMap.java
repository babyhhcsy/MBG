/*
 * 文件名： JsonMap.java
 * 
 * 工程名称: transaction
 *
 * CPP
 *
 * 创建日期： 2014年8月6日
 *
 * Copyright(C) 2014, by cpp.
 *
 * 原始作者: 张治钢	
 *
 */
package com.thero.framework.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 描述：返回json数据封装的Map结构
 *
 * @author mailto:zhangzg@china-cpp.com
 *
 * @version 1.0
 *
 * @since 2014年8月6日
 */
public class JsonMap extends HashMap<String, Object> implements
    Map<String, Object>, Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 功能描述：构造函数，传入返回的http状态码和错误信息
     *
     * @constructor 方法
     */
    public JsonMap(int http_status, String message) {
        this.put("status", http_status);
        this.put("message", message);
    }
}
