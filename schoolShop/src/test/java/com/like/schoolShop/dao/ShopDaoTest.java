package com.like.schoolShop.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.like.schoolShop.BaseTest;
import com.like.schoolShop.dao.ShopDao;
import com.like.schoolShop.entity.Area;
import com.like.schoolShop.entity.PersonInfo;
import com.like.schoolShop.entity.Shop;
import com.like.schoolShop.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
@Autowired
	private ShopDao shopDao;
@Test
public void testQueryShopListAndCount() {
	Shop shopCondition = new Shop();
	ShopCategory childCategory = new ShopCategory();
	ShopCategory parentCategory = new ShopCategory();
	parentCategory.setShopCategoryId(12L);
	childCategory.setParent(parentCategory);
	shopCondition.setShopCategory(childCategory);
	List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 6);
	int count = shopDao.queryShopCount(shopCondition);
	System.out.println("店铺列表的大小：" + shopList.size());
	System.out.println("店铺总数：" + count);	
}

@Test
@Ignore
	public void testQueryByShopId()
	{
		long shopId=1;
		Shop shop=shopDao.queryByShopId(shopId);
		System.out.println("areaName"+shop.getArea().getAreaName());
		System.out.println("areaId"+shop.getArea().getAreaId());
	}

@Test
@Ignore
	public void testInsertShop()
	{
		Shop shop=new Shop();
		PersonInfo owner=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测317");
		shop.setShopDesc("test317");
		shop.setShopAddr("test317");
		shop.setPhone("test317");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
		@Ignore
		@Test
		public void testUpdateShop()
		{
			Shop shop=new Shop();
			shop.setShopId(1L);
			shop.setShopDesc("测试描述");
			shop.setShopAddr("测试地址");
			shop.setLastEditTime(new Date());
			int effectedNum = shopDao.updateShop(shop);
			assertEquals(1, effectedNum);
		}
		@Ignore
		@Test
		public void testQueryShopList()
		{
			
			Shop shopCondition=new Shop();
			PersonInfo owner=new PersonInfo();
			owner.setUserId(1L);
			shopCondition.setOwner(owner);
			List<Shop> shopList=shopDao.queryShopList(shopCondition, 0, 5);
			int count=shopDao.queryShopCount(shopCondition);
			System.out.println("店铺列表大小"+shopList.size());
			System.out.println("店铺总数"+count);
		}
	

}
