package com.cy.pj.bst.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.bst.dao.BstCartDao;
import com.cy.pj.bst.entity.BstCart;

import com.cy.pj.bst.service.BstCartService;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;

@Service
public class BstCartServiceImpl implements BstCartService{

	@Autowired
	private BstCartDao bstCartDao;

	@Override
	public int deleteObjects(Integer... cartIds) {
		//1.参数校验
		if(cartIds==null||cartIds.length==0)
			throw new IllegalArgumentException("请先选择");
		//2.删除记录并校验结果
		int rows=bstCartDao.deleteObjects(cartIds);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		//3.返回删除结果
		return rows;
	}

	@Override
	public PageObject<BstCart> findPageObjects(Integer userId, Integer pageCurrent) {
		//验证参数的有效性
		if(pageCurrent==null || pageCurrent<1)
			throw new IllegalArgumentException("页码值无效");
		//查询总记录数
		int rowCount=bstCartDao.getRowCount(userId);
		if(rowCount==0)
			throw new ServiceException("此购物车中还没有添加任何商品呢!");
		//查询当前页记录
		int pageSize=10;
		//对数据进行封装
		int startIndex=(pageCurrent-1)*pageSize;
		List<BstCart> records = bstCartDao.findPageObjects(userId, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}



}
