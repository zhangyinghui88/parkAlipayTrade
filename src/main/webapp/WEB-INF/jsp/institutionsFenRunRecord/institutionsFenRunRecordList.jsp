<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>机构分润记录查询</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/institutionsFenRunRecord/institutionsFenRunRecord.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<style type="text/css">
body.bootstrap-admin-with-small-navbar {
	padding-top: 62px;
}

.page-header {
	padding-bottom: 0px;
}
</style>
</head>
<body class="bootstrap-admin-with-small-navbar">
	<div class="container">
		<div class="page-header">
			<h3>机构分润记录查询</h3>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default bootstrap-admin-no-table-panel">
					<div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
						<form class="form-horizontal" onsubmit="reloadDate();return false;">
							<fieldset>
								<input type="hidden" id="limit" name="limit" />
								<input type="hidden" id="offset" name="offset" />

								<div class="form-group">
									<label class="col-lg-2 control-label" for="localBeginDate">交易时间</label>
									<div class="col-lg-2">
										<input class="form-control datepicker" id="localBeginDate" name="localBeginDate" type="text" " />
									</div>
									<label style="padding-right: 42px;" class="col-lg-1 control-label" for="target">至</label>

									<div class="col-lg-2">
										<input style="padding-left: 10px;" class="form-control datepicker" id="localEndDate" name="localEndDate" type="text" " />
									</div>


									<label class="col-lg-2 control-label" for="businessType">交易类型</label>
									<div class="col-lg-2">
										<select id="businessType" class="form-control" style="width: 150px">
											<option value="">--请选择--</option>
											<c:forEach items="${busList }" var="businessType">
												<option value="${businessType.businessType }">${businessType.businessName }</option>
											</c:forEach>
										</select>
									</div>
								</div>



								<div class="form-group">

									<label class="col-lg-2 control-label" for="mobile">交易人手机号</label>
									<div class="col-lg-5">
										<input class="form-control disabled" id="mobile" name="mobile" type="text" />
									</div>

									<label class="col-lg-1 control-label" for="target">隶属机构</label>
									<div class="col-lg-3">
										<div class="input-group">
											<input type="hidden" id="agencyName" />
											<input type="text" class="form-control" id="parentIdSelect" />
											<div class="input-group-btn">
												<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
													<span class="caret"></span>
												</button>
												<ul class="dropdown-menu dropdown-menu-right" role="menu">
												</ul>
											</div>
										</div>
									</div>

									<div style="display: none">
										<label class="col-lg-1 control-label" for="target">机构编码</label>
										<div class="col-lg-2">
											<input type="text" id="agencyId" class="form-control" />
										</div>
									</div>

								</div>


								<div class="form-group">
									<label class="col-lg-2 control-label" for="localLogno">流水号</label>
									<div class="col-lg-5">
										<input class="form-control disabled" id="localLogno" name="localLogno" type="text" />
									</div>
									<label class="col-lg-1 control-label" for="target"></label>
									<div class="col-lg-1"></div>
									<div class="col-lg-1">
										<button type="submit" class="btn btn-primary">查&nbsp;询</button>
									</div>
									<div class="col-lg-2">
										<button type="reset" class="btn btn-default">清&nbsp;空</button>
									</div>
								</div>

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<c:if test="${not empty danger}">
					<div class="alert alert-danger">
						<a class="close" href="#" data-dismiss="alert">×</a> <strong>${danger}</strong>
					</div>
				</c:if>
				<c:if test="${not empty success}">
					<div class="alert alert-success">
						<a class="close" href="#" data-dismiss="alert">×</a> <strong>${success}</strong>
					</div>
				</c:if>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<p>
				<div id="toolbar" class="btn-group">
					<shiro:hasPermission name="InstitutionsFenRunRecord:export">
						<button id="btn_export" type="button" class="btn btn-default" onclick="ExportFansCustomerJnls();">
							<span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
						</button>
					</shiro:hasPermission>
				</div>
				</p>
				<table id="mytab" class="table table-hover"></table>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function ExportFansCustomerJnls() {
			var limit = $("#limit").val();
			var offset = $("#offset").val();
			var localdate = $("#localdate").val();
			var businessType = $.trim($("#businessType").val());
			var localLogno = $.trim($("#localLogno").val());
			var mobile = $.trim($("#mobile").val());
			location.href = ctx
					+ "/institutionsFenRunRecord/institutionsFenRunIssueExportExcel?="
					+ localdate + "&businessType=" + businessType
					+ "&localLogno=" + localLogno + "&mobile" + mobile
					+ "&limit=" + limit + "&offset=" + offset;
		}
	</script>

</body>
</html>