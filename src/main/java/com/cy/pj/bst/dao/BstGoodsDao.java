package com.cy.pj.bst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.bst.entity.BstGoods;


@Mapper
public interface BstGoodsDao {
	/**
	 * 更新商品信息
	 * @param entity
	 * @return
	 */
	int updateObject(BstGoods entity);
	/**
	   * 基于id执行数据删除
	   * @param ids
	   * @return
	   */
	  int deleteObjects(@Param("ids") Integer...ids);//array
	
	/**
	  * 添加写入数据库
	  * @param entity
	  * @return
	  */
	 int insertObject(BstGoods entity);
	
	/**基于商品名查询数据*/
	int getRowCount(String name);
	
	/**基于商品名查询所有商品信息
	 * 基于开始页和页记录实现分页
	 * */
	List<BstGoods> findPageObjects(String name,Integer startIndex,Integer pageSize);

}
