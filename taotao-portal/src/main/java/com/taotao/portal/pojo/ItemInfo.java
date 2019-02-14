/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemInfo.java   
 * @Package com.taotao.portal.pojo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月14日 下午11:22:20   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.pojo;

import org.apache.commons.lang3.StringUtils;

import com.taotao.pojo.TbItem;

/**   
 * @Description: TODO 
 * @ClassName:  ItemInfo
 * @author:  Axin 
 * @date:   2019年2月14日 下午11:22:20   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public class ItemInfo extends TbItem {
	
	public String[] getImages(){
		String image = getImage();
		if(StringUtils.isNotEmpty(image)){
			return image.split(",");
		}
		return null;
	}
}
