package com.like.schoolShop.service;

import java.util.List;

import com.like.schoolShop.entity.Area;

public interface AreaService {
	public final static String AREALISTKEY="arealist";
List<Area> getAreaList();
}
