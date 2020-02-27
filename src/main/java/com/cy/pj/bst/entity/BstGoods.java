package com.cy.pj.bst.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BstGoods implements Serializable {

	/**
	 * 商品表bean
	 */
	private static final long serialVersionUID = -1925116525979857130L;
    
	//商品id
	private Integer id;
	//商品名称name
	private String name;
	//商品单价
	private Integer price;
	//父类id
	private Integer classId;
	//inventory库存,
	private Long inventory;
    //update_time库存更新时间
	private Date updateTime;
	//describe`商品描述',
	private String describe;
}
