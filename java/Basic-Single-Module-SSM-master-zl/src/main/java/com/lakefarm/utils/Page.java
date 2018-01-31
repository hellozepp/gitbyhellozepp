package com.lakefarm.utils;

import java.io.Serializable;
/**
 * 分页工具类
 * @author hpf
 */
public class Page  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int page;//第几页
	private int pageSize;//一页显示多少条记录
	private int start;//起始页
	
	public Page(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
//	public Page(int start,int pageSize){
//		this.start=start;
//		this.pageSize=pageSize;
//	}
	public Page(){}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return (page-1)*pageSize;
	}
}
