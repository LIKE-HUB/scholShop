package com.like.schoolShop.dao;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.like.schoolShop.BaseTest;
import com.like.schoolShop.dao.ProductCategoryDao;
import com.like.schoolShop.entity.ProductCategory;
/**
 * junit测试顺序随机
 * MethodSorters.JVM  代码中定义的的方法顺序执行
 * MethodSorters.NAME_ASCENDING   按照名字顺序执行
 * MethodSorters.default  默认顺序执行
 * 
 * @throws Exception
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Test
	public void testBQueryByShopId() throws Exception {
		long shopId = 1;
		List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		System.out.println("该店铺自定义类别数为：" + productCategoryList.size());
	}
	@Test
	@Ignore
	public void testABatchInsertProductCategory(){
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("商品类别1");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(1L);
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("商品类别2");
		productCategory2.setPriority(2);
		productCategory2.setCreateTime(new Date());
		productCategory2.setShopId(1L);
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
		assertEquals(2, effectedNum);
	}
	@Test
	@Ignore
	public void testCDeleteProductCategory() throws Exception
	{long shopId=1;
	List<ProductCategory> productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
	for(ProductCategory pc:productCategoryList)
	{
		if ("商品类别1".equals(pc.getProductCategoryName()) || "商品类别2".equals(pc.getProductCategoryName())) {
			int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(),
					shopId);
			assertEquals(1, effectedNum);
		}
	}
		
	}
	
}
