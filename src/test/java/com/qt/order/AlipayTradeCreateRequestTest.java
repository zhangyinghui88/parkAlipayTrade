/** 
 * 包名: package com.qt.parkTest; <br/> 
 * 添加时间: 2017年11月2日 下午5:26:19 <br/> 
 */
package com.qt.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;

/** 
 * 类名:订单创建接口示例<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年11月2日 下午5:26:19 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
public class AlipayTradeCreateRequestTest {

    static String APP_ID = "2016080700191244";
    static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbqs+RfKI6CDpQBp87XpBQyrDX/9Rl4hZ0EJncJS0pa0Q+b4k/MHQRR9gNj8nuyBesla1plGPKo8/7Br95MFPNfMUaTd+P6x+1fb3xRn2LFzvQGzt9VgpNuIEDIgGfSJkB8eXFUzpDCacqJiwP6yV9JpfVIqBg2iqMAreeBAs7p53ElmqxIOdvHNPn4mYVl0jnUonYZ6vndN/D74YqgnX/bzvnjoFYhiQ6WjhhBS6/jxFQ2z58KztJSmtRgHPuCcp7es2CVUmHVHtPKdB5TM+3MLaOnZ3VIN9pQFHNzmfK8mFy7QQv7vSibMySsogzW7s4T0bVb64SCaDj1qUOicn5AgMBAAECggEANBu/k+H2pBpw+qzczJDhGkpfXE7FGL3P6lZMSscfEQhZNdU8Siy8DbTQ++kwHYBZfGo2PGtx5Dllu5AMtFKbGuQzTpTWy2RXnvdSh9ui1taWLRmQlmog1Nd4SEYv6NPydBY3ZhBwJlSq4o8YnNOIHxa2KKCIsyMUrv2R3ZFY+USirb1mKGNeg6kfyJZBr2CiHmOObCXddCywjdS07ePqB1NY8XnPGV4rfMGww4We6zDHLRz1eA7k4wsQZyIrHib/GnDsyjT64mrV01BTofN+HcqirhePmGJwoO6CO9OJnzbdzdjEGDmSxoFLPtukIW9opwyaboMB/qP70kbp48cJoQKBgQDWPj/2Ih3M5EZkj/7q77ArjyJYC8lmyJxPbIhwlkiJw50CjmB+Lbfy0iEdOPQG8nqaEc7cMQfOCc7RwcrXfXL6LUsc9lLzr7oY7SqxpepNohkEzXnSQDkgsGgWTxRHkPzSV6BikXCm3AZkDcqtXdK6jW+10N4fCN0CdB2a+bmFPQKBgQC6AeQNGf+XpeQkIG+UMc089MsbJBxlWboxIzn2TGdjGwO4ylDlj20eQjzSj0PvVfa6cGhgpd/N2MVJNGETfFmy58zKQLLO7er+Hm4Jiasu9YG9LoxDE05gO1ccN6/07Ln2xJcU8khPaGRJkg7pdG3V5+99SKdN5vXWigRH36M7bQKBgQDFHDCsu2a/g6ZgDztx22QyL1ZhuzZpIljtmeVN8HZ8iUSDfYq5jEaZWUquICAj5CN4bLntTA7qOYvW4H1HFVwbYGCjHN3k5eBJ3qpRF10iX+i0yncyQXRN5v9cxxTZY0O4InalOTpzyir3EtlN9+xRRp9on+o8k2MDRuGWG/vb4QKBgBVgmkEXN9TJ8Apm3+v8PUZALAeWgtzzDv8OuV6hMVCmjirytZFshnHv0uWwKXKcQpryyEwzRCF4RFRBfNasd/KjyVmFTgeSOGu0O5lFBTOEa8C+VMhws5VDvKM1kzdm7Yh615JEtiLKMJxz+NrD0su+uDuB2hiN7rsVaaCJB02RAoGBAJGgzEsyzaV6YPHb0JIXioBflaBBX+VrGsUZMfb2lCCvpKGFleiD3VfXg4EeBfYnfa0OD0kwiJyhqj6CmugTJr0Yzqv4CrazKTnxc9uqA26OFzqrGkJuHA/cP8GsbQ5oHUj3FslcRnJzFabiq3pNdp+yURevXk73Dg6lJAWVm4ok";
    static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtyoGBcNgmEzskZx8BN8LHTaeH65HHac3g7lsqS2N06Tk1oDpuMw4GMTBEMtDDbycUu76vfOifpf4vco3dyRijEpMAcEObhPR/6XylNf1d1ZHPmyCI8QBX0B6p32kh0KU2G0l//fuPUYyvjkb59kD44OQGmNcdt64ENzL7/HSZjP+DvcvOidwPoOg5xEC9nOJM8/c2Esb2Gn3nq+yrEx5w6Wr3aJyxt39ydcg+4MNxcG0uTveEYBbJuU8WY9euYXB+WjiDMFwmHBL1Td/OlxZfjK78XwwBk+ZI5L9v1K8aP1BWBpgnBFIDJz/Hk3Qq32zgAOkcmHWZHCiFJ/bLu9S5wIDAQAB";
    static String sign_type = "RSA2";
    static String APP_AUTH_TOKEN = "201710BBb26773c515324b6fb642004cab7d1X63";
    
    // 编码格式
    static String charset = "UTF-8";
    // 支付宝沙箱网关
    static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    public static void main(String[] args){
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, APP_ID, APP_PRIVATE_KEY, "json", charset, 
                    ALIPAY_PUBLIC_KEY, sign_type);
            AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
            request.setBizContent(getBizContent());
            request.putOtherTextParam("app_auth_token", "201711BB4fe4a6e144cf427ebbbdcbded0b52X45");        
            AlipayTradeCreateResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                System.out.println(response.getBody());
                System.out.println(response.getTradeNo());
            System.out.println("调用成功");
            } else {
            System.out.println("调用失败");
            }
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
    public static String getBizContent(){
        JSONObject data = new JSONObject();
        data.put("out_trade_no", "20170320010102001");//商户订单号
        data.put("seller_id", "2088102170455452");//卖家支付宝用户ID
        data.put("total_amount", "18.88");
//        data.put("discountable_amount", "");// 可打折金额.!
        data.put("subject", "停车费");
        data.put("body", "车牌号码：沪C8H9K3");
        data.put("buyer_id", "2088102174838743");
//        data.put("operator_id", "0001");//商户操作员编号 !
//        data.put("store_id", "10002");//商户门店编号!
//        data.put("terminal_id", "10000");// 商户机具终端编号  !
        
        JSONObject goodsDetail = new JSONObject();
        goodsDetail.put("goods_id", "park01");  //商品的编号
        goodsDetail.put("goods_name", "停车费");//商品名称 
        goodsDetail.put("quantity", "1");//商品数量 
        goodsDetail.put("price", "2000");//商品单价，单位为元 
//        goodsDetail.put("goods_category", "");//商品类目  !
//        goodsDetail.put("body", ""); //商品描述信息 !
//        goodsDetail.put("show_url", "");//商品的展示地址  !
//        data.put("goods_detail", goodsDetail.toJSONString());
        
        JSONObject extend_params = new JSONObject();
        extend_params.put("sys_service_provider_id", "2088102170404632");//系统商编号 
//        extend_params.put("timeout_express", "");!
//        extend_params.put("business_params", "");!
//        data.put("extend_params", extend_params.toJSONString());
        return data.toJSONString();
    }
    
}

