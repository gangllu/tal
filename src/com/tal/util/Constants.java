/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * yuxin
 */
package com.tal.util;


/**
 * [文件名称]<br>
 * StatusConstants <br>
 * <br>
 * [文件描述]<br>
 * 状态常量描述类.<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-8 ver1.00 创建 yuxin <br>
 * 
 * @author yuxin
 * @version 1.00
 */
public class Constants {

	/**
	 * 构造文件隐藏
	 */
	private Constants() {

	}

	/**
	 * 收单状态
	 * 
	 * @author yuxin
	 * @version 1.00
	 */
	public static class TradeStatus {
		/**
		 * 构造文件隐藏
		 */
		private TradeStatus() {

		}

		/**
		 * 1：未申请支付
		 */
		public static final String NOTAPPLY = "1";
		/**
		 * 2：已经申请支付
		 */
		public static final String APPLY = "2";
		/**
		 * 3：支付成功
		 */
		public static final String SUCCESS = "3";
		/**
		 * 4：支付失败
		 */
		public static final String FAIL = "4";
		/**
		 * 5：订单关闭
		 */
		public static final String CLOSE = "5";
		
		/**
		 * 6：已经申请充值
		 */
		public static final String APPLY_DEPOSIT = "6";
		
		/**
		 * 获得收单订单状态的名称
		 * @param status 状态
		 * @return 状态的名称
		 */
		public static final String getName(String status){
			String strReturn = null;
			int lCode = 0;
			if(!StringUtil.isEmpty(status)){
				lCode = Integer.valueOf(status);
			}
			switch(lCode){
			   case 1:
				   strReturn = "未申请支付";
				   break;
			   case 2:
				   strReturn = "申请支付";
				   break;
			   case 3:
				   strReturn = "交易成功";
				   break;
			   case 4:
				   strReturn = "交易失败";
				   break;
			   case 5:
				   strReturn = "订单关闭";
				   break;
			   case 6:
				   strReturn = "等待银行扣款";
			   default:break;
			}
			return strReturn;
		}
		
	}
	

	/**
	 * 收单订单状态
	 * 
	 * @author yuxin
	 * @version 1.00
	 */
	public static class TradeOrderStatus {
		/**
		 * 构造文件隐藏
		 */
		private TradeOrderStatus() {

		}

		/**
		 * 00：未付款
		 */
		public static final String NOTPAY = "00";
		/**
		 * 01：已付款
		 */
		public static final String PAY = "01";

		/**
		 * 03：交易成功
		 */
		public static final String SUCCESS = "03";
		/**
		 * 04：清分完成
		 */
		public static final String DISTR = "04";
		/**
		 * 05：全额退款
		 */
		public static final String REFUND = "05";
		/**
		 * 06：交易失败
		 */
		public static final String FAIL = "06";
		/**
		 * 07：订单关闭
		 */
		public static final String CLOSE = "07";
		
		/**
		 * 获得收单订单状态的名称
		 * @param status 状态
		 * @return 状态的名称
		 */
		public static final String getName(String status){
			String strReturn = null;
			int lCode = -1;
			if(!StringUtil.isEmpty(status)){
				lCode = Integer.valueOf(status);
			}
			switch(lCode){
			   case 0:
				   strReturn = "未付款";
				   break;
			   case 1:
				   strReturn = "已付款";
				   break;
			   case 3:
				   strReturn = "交易成功";
				   break;
			   case 4:
				   strReturn = "清分完成";
				   break;
			   case 5:
				   strReturn = "全额退款";
				   break;
			   case 6:
				   strReturn = "交易失败";
				   break;
			   case 7:
				   strReturn = "订单关闭";
				   break;
			   default:break;
			}
			return strReturn;
		}

	}

	/**
	 * 支付订单状态
	 * 
	 * @author yuxin
	 * @version 1.00
	 */
	public static class PaymentOrderStatus {

		/**
		 * 构造文件隐藏
		 */
		private PaymentOrderStatus() {

		}

		/**
		 * 00:未付款;
		 */
		public static final String NOTPAY = "00";
		/**
		 * 01:付款成功;
		 */
		public static final String SUCCESS = "01";
		/**
		 * 02:付款失败;
		 */
		public static final String FAIL = "02";
		/**
		 * 03 充值成功
		 */
		public static final String DEPOSIT = "03";
		/**
		 * 04：订单关闭
		 */
		public static final String CLOSE = "04";
		
		
		
		/**
		 * 获得支付订单状态的名称
		 * @param status 状态
		 * @return 状态的名称
		 */
		public static final String getName(String status){
			String strReturn = null;
			int lCode = -1;
			if(!StringUtil.isEmpty(status)){
				lCode = Integer.valueOf(status);
			}
			switch(lCode){
			   case 0:
				   strReturn = "未付款";
				   break;
			   case 1:
				   strReturn = "付款成功";
				   break;
			   case 2:
				   strReturn = "付款失败";
				   break;
			   case 3:
				   strReturn = "充值成功";
				   break;
			   case 4:
				   strReturn = "订单关闭";
				   break;
			   default:break;
			}
			return strReturn;
		}
		
		
	}

	/**
	 * 是否已经计费
	 * 
	 * @author chenghong
	 * @version 1.00
	 */
	public static class AculatedPrice {

		/**
		 * 构造文件隐藏
		 */
		private AculatedPrice() {

		}

		/**
		 * 计费标志位：未计费
		 */
		public static final String HAS_NO_CACULATED_PRICE ="0";
		
		/**
		 * 计费标志位：已计费
		 */
		public static final String HAS_CACULATED_PRICE ="1";
	}
	
	/**
	 * 支付订单状态
	 * 
	 * @author chenghong
	 * @version 1.00
	 */
	public static class NoticeStatus {

		/**
		 * 构造文件隐藏
		 */
		private NoticeStatus() {

		}

		/**
		 * 00:未发送;
		 */
		public static final String NOSEND = "0";
		/**
		 * 01:已发送;
		 */
		public static final String SEND = "1";
		
		/**
		 * 获得退款状态的名称
		 * @param status 退款状态
		 * @return 退款状态的名称
		 */
		public static final String getName(String status){
			String strReturn = null;
			int lCode = -1;
			if(!StringUtil.isEmpty(status)){
				lCode = Integer.valueOf(status);
			}
			switch(lCode){
			   case 0:
				   strReturn = "未发送";
				   break;
			   case 1:
				   strReturn = "发送成功";
				   break;
			}
			return strReturn;
		}
	}
	
	/**
	 * 通知商户的支付结果
	 */
	public static class NoticeResult {

		/**
		 * 构造文件隐藏
		 */
		private NoticeResult() {

		}

		/**
		 * 10:成功;
		 */
		public static final String SUCCESS = "10";
		/**
		 * 11:失败;
		 */
		public static final String FAIL = "11";
		
		/**
		 * 12:支付处理中;
		 */
		public static final String UN_KNOWN = "12";
	}
	
	
	
	
	/**
	 * 高标清标志
	 * 
	 * @author pengchucai
	 * @version 1.00
	 */
	public static class HdFlag {

		/**
		 * 构造文件隐藏
		 */
		private HdFlag() {

		}

		/**
		 * 1: 高清
		 */
		public static final String HD = "1";
		
		/**
		 * 2: 标清
		 */
		public static final String SD = "2";
		
		/**
		 * 3: PC
		 */
		public static final String PC = "3";
	}
	
	
	/**
	 * 充值订单状态
	 * 
	 * @author yuxin
	 * @version 1.00
	 */
	public static class DepositOrderStatus {
		/**
		 * 构造文件隐藏
		 */
		private DepositOrderStatus() {

		}

		/**
		 * 00:未付款;
		 */
		public static final String NOTPAY = "00";
		/**
		 * 01:充值成功 ;
		 */
		public static final String SUCCESS = "01";
		/**
		 * 02:充值失败;
		 */
		public static final String FAIL = "02";
		/**
		 * 03 充值订单关闭
		 */
		public static final String CLOSE = "03";
		
		/**
		 * 获得充值订单状态名称
		 * @param status  充值订单状态
		 * @return 充值订单状态名称
		 */
		public static final String getName(String status){
			String strReturn = null;
			int lCode = -1;
			if(!StringUtil.isEmpty(status)){
				lCode = Integer.valueOf(status);
			}
			switch(lCode){
			   case 0:
				   strReturn = "未付款";
				   break;
			   case 1:
				   strReturn = "充值成功";
				   break;
			   case 2:
				   strReturn = "充值失败";
				   break; 
			   case 3:
				   strReturn = "充值订单关闭";
				   break;   
			   default:break;
			}
			return strReturn;
		}
	}
	
	/**
	 * 充值类型
	 * [文件名称]<br>
	 * DepositOrderType <br>
	 * <br>
	 * [文件描述]<br>
	 * 内容摘要.<br>
	 * <br>
	 * [修改记录]<br>
	 * 2012-4-16 ver1.00 创建 chenghong<br>
	 * 
	 * @author chenghong
	 * @version 1.00
	 */
	public static class DepositOrderType{
		/**
		 * 构造文件隐藏
		 */
		private DepositOrderType() {

		}
		
		/**
		 * 普通充值
		 */
		public static final String  COMMON_DEPOSIT = "1";
		
		/**
		 * 支付引起的充值
		 */
		public static final String  PAY_DEPOSIT = "2";
		
		/**
		 * 获得充值订单状态名称
		 * @param status  充值订单状态
		 * @return 充值订单状态名称
		 */
		public static final String getName(String orderType){
			String strReturn = null;
			int lCode = -1;
			if(!StringUtil.isEmpty(orderType)){
				lCode = Integer.valueOf(orderType);
			}
			switch(lCode){
			   case 1:
				   strReturn = "普通充值";
				   break;
			   case 2:
				   strReturn = "支付充值";
				   break; 
			   default:break;
			}
			return strReturn;
		}
	}
	

	
	/**
	 * 银行订单状态(用于银行成功订单表)
	 * 
	 * @author pengchucai
	 * @version 1.00
	 */
	public static class BankOrderStatus {
		
		/**
		 * 0:失败;
		 */
		public static final String FAIL = "0";
		
		/**
		 * 1:成功 ;
		 */
		public static final String SUCCESS = "1";
		
	}

	/**
	 * 银联支付方式
	 * 
	 * @author chenghong
	 * @version 1.00
	 */
	public static class UnionPayMethod{
		
		/**
		 * 构造方法
		 */
		private UnionPayMethod(){
			
		}
		/**
		 * 银联商户支付
		 */
		public static final String CONTACT = "1";
		
		/**
		 * 银联非商户支付
		 */
		public static final String NO_CONTACT = "2";
	}
	/**
	 * PE基础数据
	 * 
	 * @author zhuyingxi
	 * @version 1.00
	 */
	public static class PE {
		/**
		 * 隐藏构造方法
		 */
		private PE() {

		}
		
		/**
		 * 主机号
		 */
		public static final String HOST_NO = "01";
		
		/**
		 * 日记账统计范围是否包含科目
		 */
		public static final boolean DIARY_ACCT_CONTAIN_SUBJECT = true;
		
		/**
		 * 日记账统计范围是否包含商户
		 */
		public static final boolean DIARY_ACCT_CONTAIN_MERCHANT = true;
		
		/**
		 * 日记账统计范围是否包含终端用户
		 */
		public static final boolean DIARY_ACCT_CONTAIN_STBUSER = false;
		
		/**
		 * 1.借方
		 */
		public static final String DR = "1";
		/**
		 * 2.贷方
		 */
		public static final String CR = "2";
		
		/**
		 * 1.付款方
		 */
		public static final String PAYER = "1";
		/**
		 * 2.收款方
		 */
		public static final String PAYEE = "2";
		/**
		 * 3.运营方
		 */
		public static final String SP = "3";

	}
	
	/**
	 * MA余额更新方向
	 * 
	 * @author zhuyingxi
	 * @version 1.00
	 */
	public static class MA {
		/**
		 * 隐藏构造方法
		 */
		private MA() {
			
		}
		
		/**
		 * "+":加
		 */
		public static final String ADD = "+";
		/**
		 * "-":减
		 */
		public static final String MINUS = "-";
		
		/**
		 * 人民币账户
		 */
		public static String ACCT_TYPE_RMB = "10";
		
		/**
		 * 积分账户
		 */
		public static String ACCT_TYPE_POINT = "20";
		
		/**
		 * 默认会员账户数量
		 */
		public static Integer DEFAULT_ACCT_NUMBER = 2;
		
		/**
		 * 商户类别
		 */
		public static final String MEMBER_TYPE_MERCHANT = "10";
		/**
		 * 终端用户类别
		 */
		public static final String MEMBER_TYPE_STB = "20";
		/**
		 * 临时会员
		 */
		public static final String MEMBER_TYPE_OTHER = "30";
		/**
		 * 积分类别
		 */
		public static final String MEMBER_TYPE_SCORE = "50";
		
		/**
		 * 商户类别
		 */
		public static final String MEMBER_TYPE_MERCHANT_STRING = "商户企业";
		/**
		 * 终端用户类别
		 */
		public static final String MEMBER_TYPE_STB_STRING = "终端用户";
		/**
		 * 运营相关类别
		 */
		public static final String MEMBER_TYPE_OTHER_STRING = "临时会员";
		
		/**
		 * 支付
		 */
		public static final String BALANCE_TYPE_PAY = "1";
		
		/**
		 * 其他
		 */
		public static final String BALANCE_TYPE_OTHER = "0";
		
		/**
		 * 积分充值
		 */
		public static final String BALANCE_TYPE_SCORE = "2";
		
		/**
		 * 个人用户
		 */
		public static String STB_TYPE = "2";
		
		/**
		 * 商户管理员
		 */
		public static String MERCHANT_TYPE = "1";
			
		/**
		 * 商户操作员
		 */
		public static String MERCHANT_OPERATOR_TYPE = "0";
		
		/**
		 * 资金正常状态
		 */
		public static String NOT_FROZEN = "1";
		
		/**
		 * 资金冻结状态
		 */
		public static String IS_FROZEN = "0";
		
		/**
		 * 外部编号标识
		 */
		//银联号
		public static String OUTSIDE_CODE_UNION = "1";
		
		/**
		 * 加密密钥
		 */
		public static String KEY = "121212121212121212121212";
		
	}
	
	/**
	 * 订单大类
	 */
	public static class OrderType {
		/**
		 * FI类订单
		 */
		public static final String FI = "1";
		/**
		 * FO类订单
		 */
		public static final String FO = "2";
		
	}
	
	/**
	 * 账户类别(科目类别)
	 */
	public static class AcctType {
		/**
		 * 资产类
		 */
		public static final String ASSETS = "1";
		/**
		 * 负债类
		 */
		public static final String LIABILITY = "2";
		/**
		 * 所有者权益类
		 */
		public static final String OWNERS_EQUITY = "3";
		/**
		 * 资产负债共同类
		 */
		public static final String COMMON = "4";
		/**
		 * 损益类
		 */
		public static final String PROFIT_AND_LOSS = "5";
		
	}
	
	public static class OrderCode {
		/**
		 * 隐藏构造方法
		 */
		private OrderCode() {

		}
		
		/**
		 * 100.充值
		 */
		public static final String DEPOSIT = "100";
		/**
		 * 110.支付
		 */
		public static final String PAYMENT = "110";
		/**
		 * 120.退款
		 */
		public static final String REFUND = "120";
		/**
		 * 300.提现
		 */
		public static final String WITHDRAWAL = "300";
		/**
		 * 310.提现退票
		 */
		public static final String REJECT_BILL = "310";
		/**
		 * 200.积分交易
		 */
		public static final String POINT_DEAL = "200";
		/**
		 * 210.积分充值
		 */
		public static final String POINT_DEPOSIT = "210";
		/**
		 * 400.渠道支付
		 */
		public static final String CHANNEL_PAY = "400";
	}
	
	/**
	 * 交易类型
	 */
	public static class DealCode {
		/**
		 * 隐藏构造方法
		 */
		private DealCode() {

		}
		
		/**
		 * 101.普通充值
		 */
		public static final String DEPOSIT_MEMBER_ACCT = "101";
		/**
		 * 102.银行卡支付充值
		 */
		public static final String DEPOSIT_BANK_PAYMENT = "102";
		/**
		 * 111.银行卡支付
		 */
		public static final String BANK_PAYMENT = "111";
		/**
		 * 112.平台账户支付
		 */
		public static final String ACCT_PAYMENT = "112";
		/**
		 * 113.银联商户支付
		 */
		public static final String UNION_PAY_PAYMENT = "113";
		/**
		 * 121.退款申请
		 */
		public static final String REFUND_APPLY = "121";
		/**
		 * 122.退款审核通过
		 */
		public static final String REFUND_CHECK_PASS = "122";
		/**
		 * 123.退款审核拒绝
		 */
		public static final String REFUND_CHECK_REFUSE = "123";
		
		/**
		 * 123.退款成功
		 */
		public static final String REFUND_SUCCESS = "124";
		/**
		 * 301.提现申请
		 */
		public static final String WITHDRAWAL_APPLY = "301";
		/**
		 * 302.提现成功
		 */
		public static final String WITHDRAWAL_SUCCESS = "302";
		/**
		 * 311.提现退票
		 */
		public static final String REJECT_BILL = "311";
		/**
		 * 201.积分发放
		 */
		public static final String POINT_POST = "201";
		/**
		 * 202.积分回收
		 */
		public static final String POINT_GET = "202";
		/**
		 * 211.积分充值
		 */
		public static final String POINT_DEPOSIT = "211";
		/**
		 * 401.渠道支付
		 */
		public static final String CHANNEL_PAYMENT = "401";
		/**
		 * 获得交易类型名称
		 * @param dealCode  交易类型
		 * @return 交易类型名称
		 */
		public static final String getName(String dealCode){
			String strReturn = null;
			int lCode = -1;
			if(!StringUtil.isEmpty(dealCode)){
				lCode = Integer.valueOf(dealCode);
			}
			switch(lCode){
			   case 101:
				   strReturn = "充值平台账户";
				   break;
			   case 102:
				   strReturn = "充值中间科目";
				   break;
			   case 111:
				   strReturn = "银行卡支付";
				   break;
			   case 112:
				   strReturn = "平台账户支付";
				   break;
			   case 113:
				   strReturn = "银联商户支付";
				   break;
			   case 121:
				   strReturn = "退款申请";
				   break;   
			   case 122:
				   strReturn = "退款成功";
				   break;   
			   case 123:
				   strReturn = "退款失败";
				   break; 
			   case 301:
				   strReturn = "提现申请";
				   break; 
			   case 302:
				   strReturn = "提现成功";
				   break; 
			   case 311:
				   strReturn = "提现退票";
				   break; 
			   default:break;
			}
			return strReturn;
		}
		
	}
	
	/**
	 * 价格策略作用域
	 */
	public static class AcctFixTable {
		
		/**
		 * 隐藏构造方法
		 */
		private AcctFixTable() {

		}
		
		/**
		 * 充值对账表
		 */
		public static final String DEPOSIT = "T_A_ACCT_FIX_DEPOSIT";
		
		/**
		 * 支付对账表
		 */
		public static final String PAYMENT = "T_A_ACCT_FIX_PAYMENT";
		
		/**
		 * 退款对账表
		 */
		public static final String REFUND = "T_A_ACCT_FIX_REFUND";
		
		/**
		 * 提现对账表
		 */
		public static final String WITHDRAWAL = "T_A_ACCT_FIX_WITHDRAWAL";
		
	}
	
	/**
	 * 价格策略作用域
	 */
	public static class EffectiveOn {
		/**
		 * 隐藏构造方法
		 */
		private EffectiveOn() {

		}
		
		/**
		 * 1.特定会员
		 */
		public static final String MEMBER = "1";
		/**
		 * 2.特定服务等级
		 */
		public static final String SERVICE_LEVEL = "2";
		/**
		 * 3.全局
		 */
		public static final String GLOBAL = "3";
		
	}
	
	/**
	 * 交易状态
	 */
	public static class DealStatus {
		/**
		 * 隐藏构造方法
		 */
		private DealStatus() {

		}
		
		/**
		 * 1.交易进行中
		 */
		public static final String DEAL_RUNNING = "1";
		/**
		 * 2.交易成功
		 */
		public static final String DEAL_SUCCESS = "2";
		/**
		 * 0.交易失败
		 */
		public static final String DEAL_FAILURE = "3";
		
	}
	
	/**
	 * 分录类型
	 */
	public static class EntryType {
		/**
		 * 隐藏构造方法
		 */
		private EntryType() {
			
		}
		
		/**
		 * 1.交易类
		 */
		public static final String DEAL = "1";
		/**
		 * 2.计费类
		 */
		public static final String BILLING = "2";
		/**
		 * 3.成本类
		 */
		public static final String BANK = "3";
		/**
		 * 4.手工凭证类
		 */
		public static final String COST = "4";
		/**
		 * 5.手工凭证类
		 */
		public static final String CERTIFICATE = "5";
	}
	
	/**
	 * 分录状态
	 */
	public static class EntryStatus {
		/**
		 * 隐藏构造方法
		 */
		private EntryStatus() {
			
		}
		
		/**
		 * 1.已记账
		 */
		public static final String ENTRY_RECORDED = "1";
		/**
		 * 2.未记账
		 */
		public static final String ENTRY_UNRECORDED = "0";
		
	}
	
	/**
	 * 机构类型
	 */
	public static class OrgType {
		private OrgType() {
			super();
		}
		
		/**
		 * 入款机构类型
		 */
		public static final String FI_ORG_TYPE = "1";
		
		/**
		 * 出款机构类型
		 */
		public static final String FO_ORG_TYPE = "2";
		
		/**
		 * 银行手续费类型
		 */
		public static final String BANK_FEE_TYPE = "3";
	}
	
	/**
	 * 支付方式
	 * 
	 * @author chenghong
	 * @version 1.00
	 */
	public static class PayMethod {
		private PayMethod() {
			super();
		}
		
		/**
		 * 平台账户支付
		 */
		public static final String ACCT_PAY = "0001";
		
		/**
		 * 银行储蓄卡支付
		 */
		public static final String BANK_PAY = "0002";
		
		/**
		 * 预付费卡支付
		 */
		public static final String PREPAID_CARD_PAY = "0003";
		
		/**
		 * 信用卡支付
		 */
		public static final String CREDIT_CARD_PAY = "0004";
		
		/**
		 * 银联支付
		 */
		public static final String UNION_PAY = "0005";
		
		/**
		 * 渠道支付
		 */
		public static final String CHANNEL_PAY = "0006";
		
		
		/**
		 *平台账户与银行卡支付 组合支付
		 */
		public static final String ACCT_BANK_PAY = "0101";
		
		/**
		 * 平台账户与预付费卡支付 组合支付
		 */
		public static final String ACCT_PREPAID_CARD_PAY = "0102";
		
		/**
		 * 获得支付方式名称
		 * @param payMethod  支付方式
		 * @return 支付方式名称
		 */
		public static final String getName(String payMethod){
			String strReturn = null;
			int lCode = -1;
			if(!StringUtil.isEmpty(payMethod)){
				lCode = Integer.valueOf(payMethod);
			}
			switch(lCode){
			   case 1:
				   strReturn = "平台账户支付";
				   break;
			   case 2:
				   strReturn = "银行储蓄卡支付";
				   break;
			   case 3:
				   strReturn = "预付费卡支付";
				   break;
			   case 4:
				   strReturn = "信用卡支付";
				   break;
			   case 5:
				   strReturn = "银联支付";
				   break;
			   case 6:
				   strReturn = "渠道支付";
				   break;
			   case 101:
				   strReturn = "平台账户与银行卡支付 组合支付";
				   break;   
			   case 102:
				   strReturn = "平台账户与预付费卡支付 组合支付";
				   break;   
			   default:break;
			}
			return strReturn;
		}
	}
	

	/**
	 * 
	 * 日志报文类型
	 */
	public static class LogType {
		/**
		 * 0  发送的报文
		 */
		public static final String SEND = "0";
		
		/**
		 * 1 接收的报文
		 */
		public static final String RECEIVED = "1";
		
	}

	/**
	 * 
	 * 银行通知类型
	 */
	public static class BankNoticeType {
		/**
		 * 0 URL结果 
		 */
		public static final String URL_NOTICE = "0";
		
		/**
		 * 1  API结果
		 */
		public static final String API_NOTICE = "1";
	}
	
	/**
	 * 
	 * 银行通知结果
	 */
	public static class BankNoticeResult {
		/**
		 * 0 失败 
		 */
		public static final String FAIL = "0";
		
		/**
		 * 1  成功
		 */
		public static final String SUCCESS = "1";
	}
	
	
	
	
	public static class Person{
		/**
		 * 加密密钥
		 */
		public static String KEY = "212121212121212121212121";
	}
	
}
