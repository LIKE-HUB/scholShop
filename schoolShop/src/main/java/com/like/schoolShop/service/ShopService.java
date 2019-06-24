package com.like.schoolShop.service;
import com.like.schoolShop.dto.ImageHolder;
import com.like.schoolShop.dto.ShopExecution;
import com.like.schoolShop.entity.Shop;
import com.like.schoolShop.execptions.ShopOperationException;

public interface ShopService 
{
	/*
	 * 根据shopCondition分页返回列表数据
	 * 
	 */
	public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
	
	/*
	 * 
	 * 通过店铺ID获取店铺信息
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * 更新店铺信息，包括对图片的处理
	 * 
	 * @param shop
	 * @param shopImg
	 * @return
	 * @throws ShopOperationException
	 */
	
	
ShopExecution addShop(Shop shop,ImageHolder thumbnail)throws ShopOperationException;

ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;;
}
