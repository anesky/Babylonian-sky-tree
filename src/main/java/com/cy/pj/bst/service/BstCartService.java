package com.cy.pj.bst.service;

import com.cy.pj.bst.entity.BstCart;

import com.cy.pj.common.vo.PageObject;

public interface BstCartService {
	/**
	 * 基于购物车id删除购物车中商品信息
	 * 
	 * */
    int deleteObjects(Integer...cartId);
	
	/**
	 * 基于购物车id查询数据，进行分页查询，并对结果进行封装。
	 * 
	 */
     
	PageObject<BstCart> findPageObjects(Integer userId,Integer pageCurrent);

}
