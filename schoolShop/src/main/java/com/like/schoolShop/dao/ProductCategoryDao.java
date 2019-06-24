package com.like.schoolShop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.like.schoolShop.entity.ProductCategory;

public interface ProductCategoryDao {
/*
 * 通过shopid查询店铺商品类别
 * 
 */
	List<ProductCategory> queryProductCategoryList(long shopId);
	
 /*
  * 批量新增商品类别
  * 
  */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	
	
	/**
	 * 删除指定商品类别
	 * 
	 * @param productCategoryId
	 * @param shopId
	 * @return effectedNum
	 */
	int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);

	
	
}
