package com.like.schoolShop.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.like.schoolShop.BaseTest;
import com.like.schoolShop.dao.WechatAuthDao;
import com.like.schoolShop.entity.PersonInfo;
import com.like.schoolShop.entity.WechatAuth;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatAuthDaoTest extends BaseTest {
	@Autowired
	private WechatAuthDao wechatAuthDao;

	@Test
	public void testAInsertWechatAuth() throws Exception {
		// 新增一条微信帐号
		WechatAuth wechatAuth = new WechatAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(6L);
		// 给微信帐号绑定上用户信息
		wechatAuth.setPersonInfo(personInfo);
		// 随意设置上openId
		wechatAuth.setOpenId("dafahizhfdhaih12");
		wechatAuth.setCreateTime(new Date());
		int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testBQueryWechatAuthByOpenId() throws Exception {
		WechatAuth wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("dafahizhfdhaih1");
		assertEquals("测试1", wechatAuth.getPersonInfo().getName());
	}

}
