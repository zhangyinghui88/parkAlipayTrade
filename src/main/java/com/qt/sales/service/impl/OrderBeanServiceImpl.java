package com.qt.sales.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.StringUtils;
import com.qt.sales.dao.OrderBeanMapper;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBeanExample;
import com.qt.sales.service.OrderBeanService;


@Service("orderBeanService")
public class OrderBeanServiceImpl implements OrderBeanService {

	@Resource
	private OrderBeanMapper orderBeanMapper;
	
	@Override
	public int countByExample(OrderBeanExample example) {
		return orderBeanMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(OrderBeanExample example) {
		return orderBeanMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String orderNo) {
		// TODO Auto-generated method stub
		return orderBeanMapper.deleteByPrimaryKey(orderNo);
	}

	@Override
	public int insert(OrderBean record) {
		// TODO Auto-generated method stub
		return orderBeanMapper.insert(record);
	}

//	@Override
//	public int insertSelective(OrderBean record) {
//		// TODO Auto-generated method stub
//		return orderBeanMapper.insertSelective(record);
//	}

	@Override
	public List<OrderBean> selectByExample(OrderBeanExample example) {
		return orderBeanMapper.selectByExample(example);
	}

	@Override
	public OrderBean selectByPrimaryKey(String orderNo) {
		// TODO Auto-generated method stub
		return orderBeanMapper.selectByPrimaryKey(orderNo);
	}

	@Override
	public int updateByExampleSelective(OrderBean record, OrderBeanExample example) {
		// TODO Auto-generated method stub
		return orderBeanMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(OrderBean record, OrderBeanExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(OrderBean record) {
		return orderBeanMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrderBean record) {
		return orderBeanMapper.updateByPrimaryKey(record);
	}

	@Override
	public String queryPaidMoneyWithOrderNo(String outOrderNo) {
		return orderBeanMapper.queryPaidMoneyWithOrderNo(outOrderNo);
	}

    @Override
    public OrderBean selectByOrderNo(String orderNo) {
        return orderBeanMapper.selectByOrderNo(orderNo);
    }
    
    @Override
    public OrderBean selectPayOrderByOrderNo(String orderNo) {
        return orderBeanMapper.selectPayOrderByOrderNo(orderNo);
    }
    
    
    @Override
    public int insertFromOrder(OrderBean record){
    	if("0".equals(record.getOrderNo())){
    		orderBeanMapper.insertFromOrder(record);
    	}else{
    		int count = orderBeanMapper.selectCountByOrderNo(record.getOrderNo());
    		if(count==0){
    			orderBeanMapper.insertFromOrder(record);
    		}
    	}
    	return 1;
    }

	@Override
	public int updateOrderPayByOrderNo(OrderBean record) {
		return orderBeanMapper.updateOrderPayByOrderNo(record);
	}

	@Override
	public String queryTempPaidWithOrderTrade(String orderTrade) {
		return orderBeanMapper.queryTempPaidWithOrderTrade(orderTrade);
	}

	@Override
	public int deleteWithOrderTrade(String orderTrade) {
		return orderBeanMapper.deleteWithOrderTrade(orderTrade);
	}
	
	@Override
	public void updateAgreementNotify(Map<String, String> params) throws QTException{
        //获取内容信息
        String bizContent = params.get("biz_content");
        if (StringUtils.isEmpty(bizContent)) {
            throw new QTException("无法取得业务内容信息");
        }
        //将XML转化成json对象
        JSONObject bizContentJson = JSONObject.parseObject(bizContent);
        // 1.获取消息类型信息 
        String agreementStatus = bizContentJson.getString("agreement_status");
        if (StringUtils.isEmpty(agreementStatus)) {
            throw new QTException("无法取得变更状态");
        }
        String carNumber = bizContentJson.getString("car_number");
        String updateTime = bizContentJson.getString("update_time");
        OrderBean bean = new OrderBean();
        bean.setCarNumber(carNumber);
        bean.setAgreementStatus(agreementStatus);
        bean.setUpdateTime(updateTime);
        orderBeanMapper.updateAgreementStatus(bean);
	}

    @Override
    public String queryPaidWithCarNumber(String carNumber) {
        return orderBeanMapper.queryPaidWithCarNumber(carNumber);
    }

	@Override
	public Integer queryOrderPayCountByOrderNo(String outOrderNo) {
		return orderBeanMapper.queryOrderPayCountByOrderNo(outOrderNo);
	}
	

}
