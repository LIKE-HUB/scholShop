package com.like.schoolShop.service;

import java.util.List;

import com.like.schoolShop.dto.ProductCategoryExecution;
import com.like.schoolShop.entity.ProductCategory;
import com.like.schoolShop.execptions.ProductCategoryOperationException;

public interface ProductCategoryService {
/*
 * 查询指定店铺下的所有商品类别信息
 * long shopId
 */
	List<ProductCategory> getProductCategoryList(long shopId);
	
	
	/**
	 * 
	 * @param productCategory
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException;
	/**
	 * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException;	
}
