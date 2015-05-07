package com.thero.framework.util;

import javax.servlet.http.HttpServletRequest;

import com.thero.framework.common.Pager;


public class PageParamsUtil {
	private String pageNoStr;
	private String pageSizeStr;
	private Integer pageNo;
	private Integer pageSize;
	public PageParamsUtil() {
	}
	public PageParamsUtil(String pageNoStr, String pageSizeStr, Integer pageNo,
			Integer pageSize) {
		super();
		this.pageNoStr = pageNoStr;
		this.pageSizeStr = pageSizeStr;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public static PageParamsUtil getPageParams(HttpServletRequest request){
		String pageNoStr = request.getParameter("pageNo");
		String pageSizeStr = request.getParameter("pageSize");
		Integer pageNo = Integer.valueOf(pageNoStr != null ? pageNoStr : "1");
		Integer pageSize = Integer.valueOf(pageSizeStr != null 
				? pageSizeStr : Pager.DEFAULT_COUNT_ON_EACH_PAGE+"");
		return new PageParamsUtil(pageNoStr,pageSizeStr,pageNo,pageSize);
	}
	
	public String getPageNoStr() {
		return pageNoStr;
	}
	public void setPageNoStr(String pageNoStr) {
		this.pageNoStr = pageNoStr;
	}
	public String getPageSizeStr() {
		return pageSizeStr;
	}
	public void setPageSizeStr(String pageSizeStr) {
		this.pageSizeStr = pageSizeStr;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
