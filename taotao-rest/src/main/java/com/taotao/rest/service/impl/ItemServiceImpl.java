/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemServiceImpl.java   
 * @Package com.taotao.rest.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月14日 下午9:48:21   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ItemService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemServiceImpl
 * @author:  Axin 
 * @date:   2019年2月14日 下午9:48:21   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	//过期时间
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;
	
	@Override
	public TaotaoResult getItemBaseInfo(long itemId) {
		
		//添加缓存逻辑
		//从缓存中取商品信息，商品id对应的信息
		try {
			String string = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":base");
			//判断是否有值
			if(StringUtils.isNotEmpty(string)){
				//把string转换成java对象
				TbItem item = JsonUtils.jsonToPojo(string, TbItem.class);
				return TaotaoResult.ok(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//从数据库中查询信息
		TbItem item = this.itemMapper.selectByPrimaryKey(itemId);
		try {
			//把商品信息写入缓存
			//redis中的hash类型的key不能设置过期时间，如果还对key进行分类可以使用折中的方案。
			//key的命名方式：
			//hao456:javaee16:01=zhangsan
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":base", JsonUtils.objectToJson(item));
			//设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":base", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return TaotaoResult.ok(item);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.service.ItemService#getItemDesc(long)
	 */
	@Override
	public TaotaoResult getItemDesc(long itemId) {
		
		
		//添加缓存逻辑
		// 从缓存中取商品信息，商品id对应的信息
		try {
			String string = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":desc");
			// 判断是否有值
			if (StringUtils.isNotEmpty(string)) {
				// 把string转换成java对象
				TbItemDesc item = JsonUtils.jsonToPojo(string, TbItemDesc.class);
				return TaotaoResult.ok(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbItemDesc itemDesc = this.itemDescMapper.selectByPrimaryKey(itemId);
		try {
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":desc", JsonUtils.objectToJson(itemDesc));
			//设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":desc", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoResult.ok(itemDesc);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.service.ItemService#getItemParam(long)
	 */
	@Override
	public TaotaoResult getItemParam(long itemId) {
		
		// 从缓存中取商品信息，商品id对应的信息
		try {
			String string = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":param");
			// 判断是否有值
			if (StringUtils.isNotEmpty(string)) {
				// 把string转换成java对象
				TbItemParamItem paramItem = JsonUtils.jsonToPojo(string, TbItemParamItem.class);
				return TaotaoResult.ok(paramItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbItemParamItemExample example = new TbItemParamItemExample();
		example.createCriteria().andItemIdEqualTo(itemId);
		List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
		if(!CollectionUtils.isEmpty(list)){
			TbItemParamItem paramItem = list.get(0);
			try {
				jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":param", JsonUtils.objectToJson(paramItem));
				//设置key的有效期
				jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":param", REDIS_ITEM_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return TaotaoResult.ok(paramItem);
		}
		return TaotaoResult.build(400, "无此商品规格");
	}
	
	
	
	

}
