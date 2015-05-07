package com.thero.mapper.common.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 */

@SuppressWarnings("all")
public class Pager<T> implements Serializable {

    // 排序方式
    public enum OrderType {
        asc, desc
    }

    public static final Integer MAX_PAGE_SIZE = 100000;// 每页最大记录数限制
    public static final int DEFAULT_COUNT_ON_EACH_PAGE = 10;// 每页默认条数
    public String max_count = "100000";
    private Integer pageNo = 1;// 当前页码
    private Integer pageSize = DEFAULT_COUNT_ON_EACH_PAGE;// 每页记录数
    private Integer totalCount = 0;// 总记录数
    private Integer pageCount = 0;// 总页数
    private List<T> list;// 数据List
    private Integer startIndex;// first pagenum 显示的第一条记录是多少[开始条数]

    private Integer maxShowPageCount = 6;// 默认显示 。。。多少个页数出现... 分页显示用到
    private Integer segment;// 分隔的当前页码段
    private Integer startPageNumber;// 默认显示 。。。开始页数... 分页显示用到
    private Integer endPageNumber;// 默认显示 。。。结束页数 ... 分页显示用到

    private List<Integer> showpagerList = new ArrayList<Integer>();// 循环显示页号码
    private List<Integer> showpagerNumList = new ArrayList<Integer>();// 循环显示页号码
    
    private String url; // 提交的URL，带参数

    // 封装到LIST
    // -页面循环

    public Pager() {
        this(DEFAULT_COUNT_ON_EACH_PAGE);
        list = new ArrayList();
    }

    public Pager(int pageSize) {
        this.pageSize = 1;
        if (pageSize < 1) {
            throw new IllegalArgumentException(
                "Count should be greater than zero!");
        } else {
            this.pageSize = pageSize;
        }
    }

    public Pager(int pageNo, int pageSize) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
        if (pageSize < 1) {
            throw new IllegalArgumentException(
                "Count should be greater than zero!");
        } else {
            this.pageSize = pageSize;
        }
    }

    public String getMax_count() {
        return max_count;
    }

    public void setMax_count(String maxCount) {
        max_count = maxCount;
    }

    public List<Integer> getShowpagerList() {
        for (int i = getStartPageNumber(); i <= getEndPageNumber(); i++) {
            showpagerList.add(i);
        }
        return showpagerList;
    }

    public List<Integer> getShowpagerNumList() {
        for (int i = 1; i <= this.getPageCount(); i++) {
            showpagerNumList.add(i);
        }
        return showpagerNumList;
    }

    public void setShowpagerNumList(List<Integer> showpagerNumList) {
        this.showpagerNumList = showpagerNumList;
    }

    public Integer getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    public int getStartIndex() {
        if ((pageNo - 1) * pageSize > totalCount)
            startIndex = totalCount;
        if ((pageNo - 1) * pageSize < 0)
            startIndex = 0;
        else
            startIndex = (pageNo - 1) * pageSize;
        return startIndex;
    }

    public Integer getSegment() {
        this.segment = (pageNo - 1) / maxShowPageCount;
        if ((pageNo - 1) % maxShowPageCount >= 0) {
            segment++;
        }
        if (this.segment < 1) {
            this.segment = 1;
        }
        return segment;
    }

    public Integer getStartPageNumber() {
        this.startPageNumber = (getSegment() - 1) * maxShowPageCount + 1;
        if (this.startPageNumber < 1) {
            this.startPageNumber = 1;
        }
        return startPageNumber;
    }

    public Integer getEndPageNumber() {
        this.endPageNumber = getSegment() * maxShowPageCount;
        if (this.endPageNumber > pageCount) {
            this.endPageNumber = pageCount;
        }
        return endPageNumber;
    }

    public void setSegment(Integer segment) {
        this.segment = segment;
    }

    public void setStartPageNumber(Integer startPageNumber) {
        this.startPageNumber = startPageNumber;
    }

    public void setEndPageNumber(Integer endPageNumber) {
        this.endPageNumber = endPageNumber;
    }

    public void setShowpagerList(List<Integer> showpagerList) {
        this.showpagerList = showpagerList;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1)
            pageNo = 1;
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            pageSize = 15;
        } else if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        pageCount = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageCount++;
        }
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getMaxShowPageCount() {
        return maxShowPageCount;
    }

    public void setMaxShowPageCount(Integer maxShowPageCount) {
        this.maxShowPageCount = maxShowPageCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getPageNoForString() {
        return String.valueOf(this.getPageNo());
    }

    public String getStartIndexForString() {
        return String.valueOf(this.getStartIndex());
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}