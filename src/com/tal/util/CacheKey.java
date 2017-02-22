/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * CacheKey.java
 */
package com.tal.util;


/**
 * [文件名称]<br>
 * CacheKey <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * <br>
 * [修改记录]<br>
 * 2011-10-19 ver1.00 创建 chenghong<br>
 * 
 * @author chenghong
 * @version 1.00
 */
public class CacheKey {

	/**
	 * 收单KEY
	 */
	public static String TRADE = "trade_";
	/**
	 * 风控限额限次缓存主键
	 */
	public static String RISK_LIMIT = "risk_identify_";	
	
	
	/**
	 * 充值算费结果缓存key的前缀
	 */
	public static final String DEPOSIT_FEE = "depositFee_";
	
	/**
	 * 支付算费结果缓存key的前缀
	 */
	public static final String PAYMENT_FEE = "paymentFee_";
	
	/**
	 * 后台操作员退款算费 缓存，key的前缀
	 */
	public static final String SYS_REFUND = "sys_refund_";
	
	/**
	 * 后台操作员退款订单 缓存，key的前缀
	 */
	public static final String SYS_REFUNDORDER = "sys_refundOrder_";
	
	/**
	 * 商户门户退款算费 缓存，key的前缀
	 */
	public static final String MERCH_REFUND = "merchant_refund_";
	
	/**
	 * 商户门户退款订单 缓存，key的前缀
	 */
	public static final String MERCH_REFUNDORDER = "merchant_refundOrder_";
	
}
