package com.like.schoolShop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.like.schoolShop.entity.ShopCategory;

public interface ShopCategoryDao {

	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")
	ShopCategory shopCategoryCondition);

}
