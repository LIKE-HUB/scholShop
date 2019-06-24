package com.like.schoolShop.service;

import java.util.List;

import com.like.schoolShop.entity.ShopCategory;

public interface ShopCategoryService {
	public final String SCLISTKEY="shopcategorylist";
List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
