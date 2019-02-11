/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchResult.java   
 * @Package com.taotao.search.pojo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月11日 下午9:02:30   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.pojo;

import java.util.List;

/**   
 * @Description: TODO 
 * @ClassName:  SearchResult
 * @author:  Axin 
 * @date:   2019年2月11日 下午9:02:30   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public class SearchResult {

	private List<Item> itemList;
	
	//总记录数
	private long recordCount;
	//总页数
	private long pageCount;
	//当前页
	private long curPage;

	/**
	 * @return the itemList
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return the recordCount
	 */
	public long getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return the pageCount
	 */
	public long getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the curPage
	 */
	public long getCurPage() {
		return curPage;
	}

	/**
	 * @param curPage the curPage to set
	 */
	public void setCurPage(long curPage) {
		this.curPage = curPage;
	}
	
	
}
