package com.like.schoolShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.like.schoolShop.dao.PersonInfoDao;
import com.like.schoolShop.entity.PersonInfo;
import com.like.schoolShop.service.PersonInfoService;

@Service
public class PersonInfoServiceImpl implements PersonInfoService 
{
	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfo getPersonInfoById(Long userId) 
	{
		return personInfoDao.queryPersonInfoById(userId);
	}
}
