package com.like.schoolShop.dao;



import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.like.schoolShop.BaseTest;
import com.like.schoolShop.entity.Area;
/*
 * 每次启动时都会调用basetest方法进行加载springdao配置文件
 * 
 */
public class AreaDaoTest extends BaseTest{
@Autowired
private AreaDao areaDao;
@Test
public void testQueryArea()
{
	List<Area> areaList=areaDao.queryArea();
	assertEquals(2,areaList.size());
}
	
}
