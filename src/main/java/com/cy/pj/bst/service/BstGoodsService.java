package com.cy.pj.bst.service;

import com.cy.pj.bst.entity.BstGoods;
import com.cy.pj.common.vo.PageObject;


public interface BstGoodsService {
	/**
	 * 更新商品以及商品对应的关系数据
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(BstGoods entity,Integer[] cartId);
	/**
	 * 将用户行为日志写入到数据库
	 * @param entity
	 */
	void saveObject(BstGoods entity);
	
	/**
	 * 基于多个id进行删除操作
	 * @param ids
	 * @return
	 */
	int deleteObjects(Integer...ids);
	
	/**
	 * 基于商品信息，进行分页查询，并对结果进行封装。
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
     
	PageObject<BstGoods> findPageObjects(String name,Integer pageCurrent);
}
