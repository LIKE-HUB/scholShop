package com.like.schoolShop.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.like.schoolShop.BaseTest;
import com.like.schoolShop.dto.ImageHolder;
import com.like.schoolShop.dto.ShopExecution;
import com.like.schoolShop.entity.Area;
import com.like.schoolShop.entity.PersonInfo;
import com.like.schoolShop.entity.Shop;
import com.like.schoolShop.entity.ShopCategory;
import com.like.schoolShop.enums.ShopStateEnum;
import com.like.schoolShop.execptions.ShopOperationException;
import com.like.schoolShop.service.ShopService;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;
	@Test
	public void testGetShopList()
	{
		Shop shopCondition=new Shop();
		ShopCategory sc=new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		ShopExecution se=shopService.getShopList(shopCondition,0,2);
		System.out.println("店铺列表数"+se.getShopList().size());
		System.out.println("店铺总数"+se.getCount());
	}
	@Test
	@Ignore
	public void testModifyShop()throws ShopOperationException,FileNotFoundException
	{
		Shop shop=new Shop();
		shop.setShopId(1L);
		shop.setShopName("修改后的名称");
		File shopImg=new File("D:\\image\\dabai.jpg");
		InputStream is=new FileInputStream(shopImg);
		ImageHolder imageHolder=new ImageHolder("dabai.jpg",is);
		ShopExecution shopExecution=shopService.modifyShop(shop, imageHolder);
		System.out.println("新图片地址"+shopExecution.getShop().getShopImg());
	}
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException
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
		shop.setShopName("测试的店铺4");
		shop.setShopDesc("test4");
		shop.setShopAddr("test4");
		shop.setPhone("test3");
		shop.setShopImg("test3");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中1");
		File shopImg=new File("D:\\image\\xiaohuang.jpg");
		InputStream is=new FileInputStream(shopImg);
		ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
		ShopExecution se=shopService.addShop(shop,imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
	}
	
}
