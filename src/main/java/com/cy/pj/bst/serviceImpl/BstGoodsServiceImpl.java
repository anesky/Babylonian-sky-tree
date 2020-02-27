package com.cy.pj.bst.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.bst.dao.BstGoodsDao;
import com.cy.pj.bst.entity.BstGoods;
import com.cy.pj.bst.service.BstGoodsService;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;

@Service
public class BstGoodsServiceImpl implements BstGoodsService{

	@Autowired
	private BstGoodsDao bstGoodsDao;

	@Override
	public PageObject<BstGoods> findPageObjects(String name, Integer pageCurrent) {
		//验证参数的有效性
		if(pageCurrent==null || pageCurrent<1)
			throw new IllegalArgumentException("页码值无效");
		//查询总记录数
		int rowCount=bstGoodsDao.getRowCount(name);
		if(rowCount==0)
			throw new ServiceException("没有此商品信息");
		//查询当前页记录
		int pageSize=10;
		//对数据进行封装
		int startIndex=(pageCurrent-1)*pageSize;
		List<BstGoods> records = bstGoodsDao.findPageObjects(name, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

	@Override
	public void saveObject(BstGoods entity) {
		bstGoodsDao.insertObject(entity);

	}

	@Override
	public int deleteObjects(Integer... ids) {
		//1.参数校验
		if(ids==null||ids.length==0)
			throw new IllegalArgumentException("请先选择");
		//2.删除记录并校验结果
		int rows=bstGoodsDao.deleteObjects(ids);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		//3.返回删除结果
		return rows;
	}

	@Override
	public int updateObject(BstGoods entity, Integer[] cartId) {


		//1.参数校验
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("用户名不允许为空");
		if(cartId==null||cartId.length==0)
			throw new IllegalArgumentException("必须为用户指定角色");
		//2.更新用户自身信息
		int rows=bstGoodsDao.updateObject(entity);
		//3.更新用户和角色关系数据
		//3.1先删除原有关系数据
		
		//3.2再添加新的关系数据
		
		//log.info("method end {}",System.currentTimeMillis());
		//4.返回结果
		return rows;
	}





}
