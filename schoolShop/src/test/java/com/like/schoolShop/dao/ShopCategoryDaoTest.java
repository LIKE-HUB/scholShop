package com.like.schoolShop.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.like.schoolShop.BaseTest;
import com.like.schoolShop.dao.ShopCategoryDao;
import com.like.schoolShop.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {
@Autowired
private ShopCategoryDao shopCategoryDao;
@Test
public void testQueryShopCategory() 
{
List<ShopCategory> shopCategoryList=shopCategoryDao.queryShopCategory(null);	
System.out.println(shopCategoryList.size());


}

}
