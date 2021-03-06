<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<title>停车付费</title>
	  <meta charset="utf-8" />
	  <meta name="description" content="" />
	  <meta name="keywords" content="" />
	  <meta name="apple-mobile-web-app-capable" content="yes" />
	  <meta name="apple-mobile-web-app-status-bar-style" content="black" />
	  <meta name="format-detection" content="telephone=no, email=no" />
	  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
	<link rel="stylesheet" href="${ctx}/js/antui/dist/antui.min.css"/>
	<script type="text/javascript" src="${ctx}/js/jquery-2.0.3.min.js"></script>
	<script src="https://as.alipayobjects.com/g/component/antbridge/1.1.1/antbridge.min.js"></script>
	<script src="${ctx}/js/antui/dist/antui.min.js"></script>
<script type="application/javascript">
    // 调试时可以通过在页面定义一个元素，打印信息，使用alert方法不够优雅
    function log(obj) {
        $("#result").append(obj).append(" ").append("<br />");
    }

    $(document).ready(function(){
        // 点击payButton按钮后唤起收银台
        $("#payButton").click(function() {
        	$.ajax({
    			type : "POST",
    			url :  "${ctx}/alipayPark/tradeCreate",
    			data : {
    				'outOrderNo':$("#outOrderNo").val(),
    				'payMoney':$("#payMoney").val(),
    				'inDuration':$("#inDuration").val(),
    				'orderTime':$("#orderTime").val(),
    				'discountMoney':$("#discountMoney").val()
    				
    			},
    			beforeSend : function() {
    			},
    			success : function(obj) {
    				if (obj.success == 'true') {
    					 tradePay(obj.message);
    				} else {
    					alert(obj.message);
    				}
    			}
    		});
        });

        // 通过jsapi关闭当前窗口，仅供参考，更多jsapi请访问
        // /aod/54/104510
        $("#closeButton").click(function() {
           AlipayJSBridge.call('closeWebview');
        });
     });

    // 由于js的载入是异步的，所以可以通过该方法，当AlipayJSBridgeReady事件发生后，再执行callback方法
    function ready(callback) {
         if (window.AlipayJSBridge) {
             callback && callback();
         } else {
             document.addEventListener('AlipayJSBridgeReady', callback, false);
         }
    }

    function tradePay(tradeNO) {
        ready(function(){
             // 通过传入交易号唤起快捷调用方式(注意tradeNO大小写严格)
             AlipayJSBridge.call("tradePay", {
                  tradeNO: tradeNO
             }, function (data) {
                 alert(JSON.stringify(data));
                 if ("9000" == data.resultCode) {
                	 //alert("支付成功");
                	 location.href = "${ctx}/alipayPark/OrderSync/"+tradeNO;
                	 
                 }
                 if ("4000" == data.resultCode) {
               	  Ali.alert({
                         title: '亲',
                         message: '订单支付失败',
                         button: '确定'
                     });
                }
                if ("6001" == data.resultCode) {
                  	  Ali.alert({
                            title: '亲',
                            message: '用户中途取消',
                            button: '确定'
                        });
                 }
             });
        });
    }
</script>
<style>
html{height: 100%;}
body{height:100%;overflow-x: hidden;}
.widget-list-panel{
	position: relative;
	background: -webkit-linear-gradient(-120deg, #2288CD, #1471B2) top right no-repeat;
	-webkit-background-size:100%;
	height: 100%;
}
.widget-list-panel .header{
	position:relative;
	padding-bottom: 32px;
	color: #fff;
	text-align: center;
	z-index: 1;
}
.widget-list-panel h1{
	font-size: 40px;
	line-height: 48px;
	font-weight: 300;
	padding-top: 32px;
}
.widget-list-panel .header-info{
	font-size: 17px;
	line-height: 21px;
	padding-top: 6px;
}
.x-bg{
	position: absolute;
	width: 50%;
	min-width: 325px;
	height: 100%;
	right: 0;
	top: 0;
	background: url('https://os.alipayobjects.com/rmsportal/ZbQiBgorAUacvlC.png') no-repeat right top;
	background-size: 100% auto;
	z-index: 1;
}

.widget-list{
	padding: 0px 15px 15px 0;
	list-style: none;
	display:table;
	table-layout: fixed;
	box-sizing: border-box;
	width: 100%;
	max-width: 1200px;
	margin: 0 auto;
}
.widget-list .widget-item {
	display: inline-block;
	list-style: none;
	width: 50%;
	padding: 15px 0 0 15px;
	box-sizing: border-box;
	text-align: center;
}
.widget-list .widget-wrap{
	display: block;
	width: 100%;
	height: 100%;
	background: rgba(255, 255, 255, 0.8);
	border-radius: 3px;
	padding: 23px 15px 20px;
	box-sizing: border-box;
}
.widget-list .widget-wrap:active{
	background: rgba(238, 238, 238, 0.85);
	border-radius: 3px;
}
.widget-list .icon{
	display: inline-block;
	width: 30px;
	height: 30px;
	background: url('https://os.alipayobjects.com/rmsportal/ErzQirFUtUPzGTm.png') no-repeat center;
	background-size: 32px auto;
}
.widget-list .icon.button{
	background-position: -1px -1px;
}

.widget-list .icon.list {
	background-position: -1px -65px;
}
.widget-list .icon.message {
	background-position: -1px -97px;
}
.widget-list .icon.notice {
	background-position: -1px -129px;
}

.widget-list .icon.popmenu {
	background-position: -1px -193px;
}
.widget-list .icon.process {
	background-position: -1px -225px;
}

.widget-list .icon.search {
	background-position: -1px -289px;
}

.widget-list .icon.tab {
	background-position: -1px -321px;
}

.widget-list .icon.dialog {
	background-position: -1px -33px;
}

.widget-list .icon.loading {
	background-position: -1px -256px;
}

.widget-list .icon.page-result {
	background-position: -1px -160px;
}

.widget-list .name{
	font-size: 15px;
	color: #000;
	margin: 9px 0 4px;
	line-height: 17px;
	font-weight: 300;
}
.widget-list .info{
	font-size: 12px;
	color: #888;
}
.widget-demo-show-panel{
	margin-top:0px;
	margin-bottom: 21px;
}

.demo .am-button, .demo .am-tab, .demo .am-message, .demo .am-notice, .demo .am-inform{
	margin-bottom: 21px;
}

.demo .am-message.multi,
.demo .am-button-wrap .am-button,
.demo .am-button-group .am-button,
.demo .am-button.bottom:last-child{
	margin-bottom: 0;
}
.demo .am-button.bottom{
	position: relative;
}

.demo .demo-content{
	padding-bottom: 60px;
}

.demo.demo-button .demo-content:last-child,
.demo.demo-loading .demo-content{
	padding-bottom: 0;
}

.demo-dialog .demo-content{
	min-height: 450px;
	background: rgba(1,1,1,0.35);
	position: relative;
}
.demo-toast .demo-content{
	min-height: 300px;
	position: relative;
}
.demo-toast .am-toast{
	position: absolute;
}
.demo-page-result .demo-content{
	min-height: 300px;
}
.demo-header{
	text-align: center;
	font-size: 30px;
	padding-top: 32px;
}
.demo-header-brief{
	text-align: center;
	color: #888;
	font-size: 18px;
	padding-bottom: 32px;
	font-weight: 300;
}
.demo-search .demo-type-title{
	font-weight: 300;
}
.demo-search .demo-type-title,
.demo-notice .demo-type-title{
	color: #888;
	font-size: 13px;
	padding: 60px 15px 9px;
	display: inline-block;
	width: 100%;
	box-sizing: border-box;
}
.demo-popmenu .demo-type-title,
.demo-dialog .demo-type-title,
.demo-page-result .demo-type-title,
.demo-toast .demo-type-title,
.demo-loading .demo-type-title{
	margin-top: 50px;
	font-size: 15px;
	padding: 11px 15px;
	background-color: #3a3a3a;
	color: #fff;
	text-align: center;
	position: relative;
}
.demo-loading .demo-type-title{
	margin-top: 0;
}
.demo-popmenu .demo-type-title i.dot{
	position: absolute;
	right: 15px;
	top: 0px;
	font-size: 24px;
	line-height: 30px;
}
.demo-popmenu .demo-content{
	position: relative;
	min-height: 160px;
}
.demo-popmenu .am-popmenu-mask{
	position: absolute;
}

.swiper-slide{
	height: auto;
	position: static;
	display: block;

}

@media only screen and (min-width: 800px) {
	.widget-list .widget-item{
		width: 33%;
	}
}

.am-list:not([am-version]) {
    padding: .1rem 0;
    display: block;
    padding-top: 0px;
    margin-top: -21px;
}
</style>

</head>
<body ontouchstart="">
<div class="widget-demo-show-panel" style="background-color: #fff; text-align: center; padding-top: 2px; padding-bottom: 20px;">
  	  <div class="am-captcha-figure fn-cent" style="font-size:15px" >
          <img style="width:30px;" src="https://t.alipayobjects.com/images/rmsweb/T1lFlgXepkXXXXXXXX.png" />	
          上海果园
      </div>
    <div class="am-ft-20" style="font-size:30px">
  		39
	</div>
</div>


<div class="am-list">
    <div class="am-list-body">
        <div class="am-list-item">
            <div class="am-list-content">应付金额</div>
            <div class="am-list-extra">13</div>
        </div>
        <div class="am-list-item">
            <div class="am-list-content">已付金额</div>
            <div class="am-list-extra">23</div>
        </div>
        <div class="am-list-item">
            <div class="am-list-content">优惠金额</div>
            <div class="am-list-extra">23</div>
        </div>
    </div>
    
    <div class="am-list-body">
        <div class="am-list-item">
            <div class="am-list-content">车牌号</div>
            <div class="am-list-extra">232</div>
        </div>
        <div class="am-list-item">
            <div class="am-list-content">入场时间</div>
            <div class="am-list-extra">23</div>
        </div>
        <div class="am-list-item">
            <div class="am-list-content">停车时长</div>
            <div class="am-list-extra">${timeDiffer }</div>
        </div>
    </div>
</div>








 <div class="am-list-header">
	  <div class="am-list-thumb right fn-left" aria-hidden="true" style="padding-left:.7em;">
	       <i class="am-icon form list"></i>
	   </div>
	    <div class="am-ft-sm am-list-brief"	>
	 	&nbsp; 请于付款后15分钟内离场，超时将加收停车费
	</div>
 </div>
<div class="am-button-wrap">
	<button class="am-button blue">立即支付</button>
</div>



<input  type ="hidden" value="${payMoney }" id="payMoney" name="payMoney"/><br />
<input  type ="hidden" value="${outOrderNo }" id="outOrderNo" name="outOrderNo"/><br />
<input  type ="hidden" value="${inDuration }" id="inDuration" name="inDuration"/><br />
<input  type ="hidden" value="${orderTime }" id="orderTime" name="orderTime"/><br />
<input  type ="hidden" value="${discountMoney }" id="discountMoney" name="discountMoney"/><br />

<c:if test="${not empty msg}">
		  <div class="am-page-result">
	        <div class="am-page-result-wrap combine-page">
	          <div class="am-page-result-pic am-icon page-err"></div>
	          <div class="am-page-result-title">${msg}</div>
	        </div>
	      </div>
</c:if>
</body>
</html>