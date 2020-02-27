package com.cy.pj.bst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.bst.entity.BstCart;



@Mapper
public interface BstCartDao {
    
	
	

	/**
	   * 基于id执行数据删除
	   * @param ids
	   * @return
	   */
	  int deleteObjects(@Param("cartIds") Integer...cartIds);//array
	

	
	/**基于购物车id查询用户购物车数据*/
	int getRowCount(Integer userId);
	
	
	List<BstCart> findPageObjects(Integer userId,Integer startIndex,Integer pageSize);
}
