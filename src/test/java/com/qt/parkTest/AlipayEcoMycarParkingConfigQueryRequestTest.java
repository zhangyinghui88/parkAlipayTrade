/** 
 * 包名: package AlipayParkTest; <br/> 
 * 添加时间: 2017年10月14日 下午10:03:01 <br/> 
 */
package com.qt.parkTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingConfigQueryRequest;
import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;

/**
 * <pre>
 * 【类型】: AlipayEcoMycarParkingConfigQueryRequestTest <br/> 
 * 【作用】: T停车ISV系统配置接口（alipay.eco.mycar.parking.config.set）. <br/>  
 * 【时间】：2017年10月24日 下午3:11:53 <br/> 
 * 【作者】：yinghui zhang <br/>
{
    "alipay_eco_mycar_parking_config_query_response": {
        "merchant_service_phone": "021-25413215",
        "merchant_logo": "",
        "merchant_name": "杭州立方kanghao123",
        "code": "10000",
        "interface_info_list": [
            {
                "interface_type": "interface_page",
                "interface_url": "https%3a%2f%2fkangguole.com.cn%2fparkAlipayTrade%2falipay",
                "interface_name": "alipay.eco.mycar.parking.userpage.query"
            }
        ],
        "msg": "Success",
        "account_no": "qcxdac2965@sandbox.com"
    },
 * </pre>
 */
public class AlipayEcoMycarParkingConfigQueryRequestTest {

    static String APP_ID = "2016080700191244";
    static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbqs+RfKI6CDpQBp87XpBQyrDX/9Rl4hZ0EJncJS0pa0Q+b4k/MHQRR9gNj8nuyBesla1plGPKo8/7Br95MFPNfMUaTd+P6x+1fb3xRn2LFzvQGzt9VgpNuIEDIgGfSJkB8eXFUzpDCacqJiwP6yV9JpfVIqBg2iqMAreeBAs7p53ElmqxIOdvHNPn4mYVl0jnUonYZ6vndN/D74YqgnX/bzvnjoFYhiQ6WjhhBS6/jxFQ2z58KztJSmtRgHPuCcp7es2CVUmHVHtPKdB5TM+3MLaOnZ3VIN9pQFHNzmfK8mFy7QQv7vSibMySsogzW7s4T0bVb64SCaDj1qUOicn5AgMBAAECggEANBu/k+H2pBpw+qzczJDhGkpfXE7FGL3P6lZMSscfEQhZNdU8Siy8DbTQ++kwHYBZfGo2PGtx5Dllu5AMtFKbGuQzTpTWy2RXnvdSh9ui1taWLRmQlmog1Nd4SEYv6NPydBY3ZhBwJlSq4o8YnNOIHxa2KKCIsyMUrv2R3ZFY+USirb1mKGNeg6kfyJZBr2CiHmOObCXddCywjdS07ePqB1NY8XnPGV4rfMGww4We6zDHLRz1eA7k4wsQZyIrHib/GnDsyjT64mrV01BTofN+HcqirhePmGJwoO6CO9OJnzbdzdjEGDmSxoFLPtukIW9opwyaboMB/qP70kbp48cJoQKBgQDWPj/2Ih3M5EZkj/7q77ArjyJYC8lmyJxPbIhwlkiJw50CjmB+Lbfy0iEdOPQG8nqaEc7cMQfOCc7RwcrXfXL6LUsc9lLzr7oY7SqxpepNohkEzXnSQDkgsGgWTxRHkPzSV6BikXCm3AZkDcqtXdK6jW+10N4fCN0CdB2a+bmFPQKBgQC6AeQNGf+XpeQkIG+UMc089MsbJBxlWboxIzn2TGdjGwO4ylDlj20eQjzSj0PvVfa6cGhgpd/N2MVJNGETfFmy58zKQLLO7er+Hm4Jiasu9YG9LoxDE05gO1ccN6/07Ln2xJcU8khPaGRJkg7pdG3V5+99SKdN5vXWigRH36M7bQKBgQDFHDCsu2a/g6ZgDztx22QyL1ZhuzZpIljtmeVN8HZ8iUSDfYq5jEaZWUquICAj5CN4bLntTA7qOYvW4H1HFVwbYGCjHN3k5eBJ3qpRF10iX+i0yncyQXRN5v9cxxTZY0O4InalOTpzyir3EtlN9+xRRp9on+o8k2MDRuGWG/vb4QKBgBVgmkEXN9TJ8Apm3+v8PUZALAeWgtzzDv8OuV6hMVCmjirytZFshnHv0uWwKXKcQpryyEwzRCF4RFRBfNasd/KjyVmFTgeSOGu0O5lFBTOEa8C+VMhws5VDvKM1kzdm7Yh615JEtiLKMJxz+NrD0su+uDuB2hiN7rsVaaCJB02RAoGBAJGgzEsyzaV6YPHb0JIXioBflaBBX+VrGsUZMfb2lCCvpKGFleiD3VfXg4EeBfYnfa0OD0kwiJyhqj6CmugTJr0Yzqv4CrazKTnxc9uqA26OFzqrGkJuHA/cP8GsbQ5oHUj3FslcRnJzFabiq3pNdp+yURevXk73Dg6lJAWVm4ok";
    static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtyoGBcNgmEzskZx8BN8LHTaeH65HHac3g7lsqS2N06Tk1oDpuMw4GMTBEMtDDbycUu76vfOifpf4vco3dyRijEpMAcEObhPR/6XylNf1d1ZHPmyCI8QBX0B6p32kh0KU2G0l//fuPUYyvjkb59kD44OQGmNcdt64ENzL7/HSZjP+DvcvOidwPoOg5xEC9nOJM8/c2Esb2Gn3nq+yrEx5w6Wr3aJyxt39ydcg+4MNxcG0uTveEYBbJuU8WY9euYXB+WjiDMFwmHBL1Td/OlxZfjK78XwwBk+ZI5L9v1K8aP1BWBpgnBFIDJz/Hk3Qq32zgAOkcmHWZHCiFJ/bLu9S5wIDAQAB";
    static String sign_type = "RSA2";
    static String APP_AUTH_TOKEN = "201710BBb26773c515324b6fb642004cab7d1X63";
    // 编码格式
    static String charset = "UTF-8";
    // 支付宝沙箱网关
    static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    public static void main(String[] args) {
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, APP_ID, APP_PRIVATE_KEY, "json", charset, 
                ALIPAY_PUBLIC_KEY, sign_type);
        AlipayEcoMycarParkingConfigQueryRequest request = new AlipayEcoMycarParkingConfigQueryRequest();
        request.setBizContent(getBizContent());//业务数据
        AlipayEcoMycarParkingConfigQueryResponse   response;
        try {
            response = alipayClient.execute(request, APP_AUTH_TOKEN);
            if (response.isSuccess()) {
                System.out.println(response.getBody());
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
        data.put("interface_name", "alipay.eco.mycar.parking.userpage.query");
        data.put("interface_type", "interface_page");
        String jsonStr = JSON.toJSONString(data);
        System.out.println(jsonStr);
        return jsonStr;
    }
}
