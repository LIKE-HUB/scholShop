package com.like.schoolShop.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.like.schoolShop.BaseTest;
import com.like.schoolShop.entity.Area;
import com.like.schoolShop.service.AreaService;
import com.like.schoolShop.service.CacheService;

public class AreaServiceTest extends BaseTest {
	@Autowired
	private AreaService areaService;
	@Autowired
	private CacheService cachaeservice;
	@Test
	public void testGetAreaList()
	{
		List<Area> areaList=areaService.getAreaList();
		assertEquals("北区",areaList.get(0).getAreaName());
		cachaeservice.removeFromCache(areaService.AREALISTKEY);
		areaList=areaService.getAreaList();
	}
}
