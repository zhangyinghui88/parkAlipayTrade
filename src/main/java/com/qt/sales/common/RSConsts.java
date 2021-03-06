package com.qt.sales.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 类名: RSConsts <br/> 
 * 创建者: Lance.Wu. <br/> 
 * 添加时间: 2016年1月18日 下午4:25:56 <br/> 
 * 版本： 
 * @since JDK 1.6 qtservices 1.0
 */
public class RSConsts {
	
    // ------------------------------------------------------------------------------------------------------
    /** 响应码 */
    public static final String QZERR = "1"; // 请求成功
    /** 响应码 */
    public static final String RESP_CODE_00_SUCCESS = "0000"; // 请求成功
    public static final String MERCHANT_NAME = "merchant_name"; 
    public static final String MERCHANT_SERVICE_PHONE = "merchant_service_phone"; 
    public static final String ACCOUNT_NO = "account_no"; 
    public static final String MERCHANT_LOGO = "merchant_logo"; 
    public static final String INTERFACE_NAME = "interface_name"; 
    public static final String INTERFACE_TYPE = "interface_type"; 
    public static final String INTERFACE_URL = "interface_url"; 
    public static final String INTERFACE_INFO_LIST = "interface_info_list"; 
    public static final String STATUS = "status"; 
    public static final String SUCCESS_CODE = "0000"; 
    public static final String FAILE_CODE = "9999"; 
    public static final String MESSAGE = "message"; 
    public static final String BODY = "body"; 
    public static final String city_id = "city_id"; 
    public static final String equipment_name = "equipment_name"; 
    public static final String out_parking_id = "out_parking_id"; 
    public static final String parking_address = "parking_address"; 
    public static final String longitude = "longitude"; 
    public static final String latitude = "latitude"; 
    public static final String parking_start_time = "parking_start_time"; 
    public static final String parking_end_time = "parking_end_time"; 
    public static final String parking_number = "parking_number"; 
    public static final String parking_lot_type = "parking_lot_type"; 
    public static final String parking_type = "parking_type"; 
    public static final String payment_mode = "payment_mode"; 
    public static final String pay_type = "pay_type"; 
    public static final String shopingmall_id = "shopingmall_id"; 
    public static final String parking_fee_description = "parking_fee_description"; 
    public static final String contact_name = "contact_name"; 
    public static final String contact_mobile = "contact_mobile"; 
    public static final String contact_tel = "contact_tel"; 
    public static final String contact_emali = "contact_emali"; 
    public static final String contact_weixin = "contact_weixin"; 
    public static final String contact_alipay = "contact_alipay"; 
    public static final String parking_name = "parking_name"; 
    public static final String time_out = "time_out"; 
    public static final String parking_id = "parking_id"; 
    public static final String car_number = "car_number"; 
    public static final String in_time = "in_time"; 
    public static final String out_time = "out_time"; 
    public static final String user_id = "user_id"; 
    public static final String out_order_no = "out_order_no"; 
    public static final String order_status = "order_status"; 
    public static final String order_time = "order_time"; 
    public static final String order_no = "order_no"; 
    public static final String pay_time = "pay_time"; 
    public static final String pay_money = "pay_money"; 
    public static final String in_duration = "in_duration"; 
    public static final String card_number = "card_number"; 
    public static final String out_trade_no = "out_trade_no"; 
    public static final String seller_id = "seller_id"; 
    public static final String total_amount = "total_amount"; 
    public static final String discountable_amount = "discountable_amount"; 
    public static final String subject = "subject"; 
    public static final String body = "body"; 
    public static final String buyer_id = "buyer_id"; 
    public static final String goods_detail = "goods_detail"; 
    public static final String goods_id = "goods_id"; 
    public static final String goods_name = "goods_name"; 
    public static final String quantity = "quantity"; 
    public static final String goods_category = "goods_category"; 
    public static final String show_url = "show_url"; 
    public static final String price = "price"; 
    public static final String operator_id = "operator_id"; 
    public static final String store_id = "store_id"; 
    public static final String terminal_id = "terminal_id"; 
    public static final String extend_params = "extend_params"; 
    public static final String sys_service_provider_id = "sys_service_provider_id"; 
    public static final String timeout_express = "timeout_express"; 
    public static final String business_params = "business_params"; 
    public static final String app_auth_token = "app_auth_token"; 
    public static final String trade_no = "trade_no"; 
    public static final String refund_amount = "refund_amount"; 
    public static final String refund_reason = "refund_reason"; 
    public static final String refund_reason_des = "正常退款"; 
    public static final String out_request_no = "out_request_no"; 
    public static final String paidMoney = "paidMoney"; 
    public static final String payMoney = "payMoney"; 
    public static final String payBtn = "payBtn"; 
    public static final String parkingName = "parkingName"; 
    public static final String discountMoney = "discountMoney"; 
    public static final String inTime = "inTime"; 
    public static final String timeDiffer = "timeDiffer"; 
    public static final String inDuration = "inDuration"; 
    public static final String orderTime = "orderTime"; 
    public static final String msg = "msg"; 
    public static final String car_id = "car_id"; 
    public static final String zero = "0.00"; 
    public static final String total_fee = "total_fee"; 
    /**
     * 卖家支付宝账号，可以为email或者手机号。如果seller_id不为空，则以seller_id的值作为卖家账号，忽略本参数。
     */
    public static final String seller_logon_id = "seller_logon_id"; 
    public static final String agent_id = "agent_id";
    public static final String agent_value = "";
    public static final String car_number_color = "car_number_color";
    public static final String car_number_color_blue = "blue";
    public static final String biz_trade_no = "biz_trade_no";
    public static final String out_biz_trade_no = "out_biz_trade_no";
    public static final String out_refund_no = "out_refund_no";
    public static final String refund_fee = "refund_fee";
    public static final String merchantLogo = "merchantLogo";
    public static final String isvPhone = "isvPhone";
    public static final String isvName = "isvName";
    public static final String TRADE_HAS_SUCCESS = "ACQ.TRADE_HAS_SUCCESS";
    public static final String orderMoney = "orderMoney";
    public static final String notify_url = "notify_url";
    public static final String TRADE_SUCCESS = "TRADE_SUCCESS";
    public static final String grant_type = "grant_type";
    public static final String refresh_token = "refresh_token";
    
    
}
