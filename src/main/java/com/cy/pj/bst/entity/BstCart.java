package com.cy.pj.bst.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public class BstCart implements Serializable{

	/**
	 * 封装购物车表数据
	 */
	
	
	private static final long serialVersionUID = 4905703418683346562L;
    //购物车id
	private Integer cartId;
	//用户id
	private Integer userId;
	//商品id
	private Integer id;
	//商品名称
	private String name;
	//商品单价
	private Integer price;
	//商品数量
	private Integer num;
	//商品总价
	private Integer totalIee;
	
	//商品总价的计算
	public BstCart(Integer price, Integer num) {
		super();
		this.price = price;
		this.num = num;
		this.totalIee=price*num;
	}
	
	
	
	
}
