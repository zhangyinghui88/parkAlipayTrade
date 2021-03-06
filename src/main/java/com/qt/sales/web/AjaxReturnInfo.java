package com.qt.sales.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * 
 * <pre>
 * 【类型】: AjaxReturnInfo <br/> 
 * 【作用】: Ajax返回值封装类. <br/>  
 * 【时间】：2016年10月31日 下午6:07:04 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class AjaxReturnInfo {
    
    public static final String TURE_RESULT = "true";
    public static final String FALSE_RESULT = "false";
    
    /**
     * true
     */
    private String               success;                              
    /**
     * 返回信息
     */
    private String                     message;                              
    /**
     * 返回的数据
     */
    private Exception                  exception;
    
    /**
     * 车牌号
     */
    private String 					carNumber;
    
    /**
     * 应付款金额
     */
    private String payMoney;
    
    /**
     * 已付款金额
     */
    private String paidMoney;
    
    /**
     *订单号
     */
    private String orderNo;
    
    /**
     * date
     */
    private Map<String, Object>        datas = new HashMap<String, Object>();
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return success .<br/>
     */
    public String getSuccess() {
        return success;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 上午9:59:43 <br/>
     * 参数: @param  success 设置值.  <br/>
     */
    public void setSuccess(String success) {
        this.success = success;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return message .<br/>
     */
    public String getMessage() {
        return message;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 上午9:59:43 <br/>
     * 参数: @param  message 设置值.  <br/>
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return exception .<br/>
     */
    public Exception getException() {
        return exception;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 上午9:59:43 <br/>
     * 参数: @param  exception 设置值.  <br/>
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return datas .<br/>
     */
    public Map<String, Object> getDatas() {
        return datas;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 上午9:59:43 <br/>
     * 参数: @param  datas 设置值.  <br/>
     */
    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return payMoney .<br/>
     */
    public String getPayMoney() {
        return payMoney;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年12月16日 下午10:26:31 <br/>
     * 参数: @param  payMoney 设置值.  <br/>
     */
    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPaidMoney() {
		return paidMoney;
	}
	public void setPaidMoney(String paidMoney) {
		this.paidMoney = paidMoney;
	} 

  

}
