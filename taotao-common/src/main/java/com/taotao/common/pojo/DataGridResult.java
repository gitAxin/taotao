/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  DataGridResult.java   
 * @Package com.taotao.common.pojo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月3日 下午9:56:07   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.common.pojo;

import java.util.List;

/**   
 * @ClassName:  DataGridResult   
 * @Description:TODO   
 * @author:  Axin 
 * @date:   2018年12月3日 下午9:56:07   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public class DataGridResult {
	
	private long total;
	
	private List<?> rows;

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return the rows
	 */
	public List<?> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	

}
