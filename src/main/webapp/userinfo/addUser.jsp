<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>用户管理</title>
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-theme.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-admin-theme.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-admin-theme-change-size.css">
        
        
        <link rel="stylesheet" media="screen" href="${ctx }/vendors/chosen/chosen.min.css">
        <link rel="stylesheet" media="screen" href="${ctx }/vendors/selectize/dist/css/selectize.bootstrap3.css">
        
        
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
</head>

<body  class="bootstrap-hsjiang-with-small-navbar">
  <form id="addUserForm" class="form-horizontal">
      <div class="modal-body">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">用户名</label>
		    <div class="col-sm-10">
		     <input type="text" class="form-control" id="loginname"  name="loginname"
		         placeholder="请输入登录名" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword" class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="userpasswd" name="userpasswd"
		         placeholder="请输入密码" />
		    </div>
		  </div>
			<div class="form-group">
		    <label class="col-sm-2 control-label">用户姓名</label>
		    <div class="col-sm-10">
		     <input type="text" class="form-control" id="username"  name="username"
		         placeholder="请输入用户姓名" />
		    </div>
		  </div>
		
		  <div class="form-group">
		    <label class="col-sm-2 control-label">状态</label>
		    <div class="col-lg-4" style="height: 300;">
		   		<select id="userstatus" data-placeholder="请选择用户状态" name="userstatus" class="chzn-select" style="width: 150px">
						<option value="0" selected="selected">启用</option>
			   			<option value="1" >停用</option>
				</select>
		    </div>
		  </div>
        
          <div class="form-group">
		    <label class="col-sm-2 control-label">用户角色</label>
	   		<div class="col-lg-4" style="height: 300;">
					<select id="userlvl" data-placeholder="请选择用户角色" name="userlvl" class="chzn-select" style="width: 150px">
							<c:forEach items="${roeInfoList }" var="roleInfo">
									<option value='${roleInfo.roleid }'>${roleInfo.roledesc }</option>
							</c:forEach>
					</select>
			</div>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" id="closeUserBtn" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" id="saveUserBtn" class="btn btn-primary">保存</button>
      </div>
   </form>
<script src="${ctx}/js/role/userinfo.js"></script>



</body>
</html>