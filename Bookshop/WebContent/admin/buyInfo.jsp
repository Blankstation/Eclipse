<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
	<table align="center" width="90%">
		<jsp:include page="ahead.jsp"/>
		<tr>
			<td n="left"><h2>购买记录</h2> </td>
		</tr>
		<!-- 查询条件 -->
		<tr>
			<td>
				<form action="<%=basePath %>buyInfoAction_buyInfo.action" method="post">
					<table width="80%" align="left">
						<tr><td>用户名:</td><td colspan="2"><input type="text" name="uname" value="${uname }"/></td><td><input type=submit value="查询"/></td> </tr>
						<tr>
						   <td>开始日期:</td>
						   <td><input type="text" name="beginDate" value="${beginDate }" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /> </td>
						   <td>结束日期:</td>
						   <td><input type="text" name="endDate" value="${endDate }" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<!-- 显示信息 -->
		<tr>
			<td>				
				<table border="1" width="100%">
					<tr><td>用户名</td><td>书名---购买数量</td><td>单价</td><td>出版社</td><td>作者</td><td>购买日期</td><td>总付款</td><td>购书总数</td></tr>
					<c:forEach var="buy" items="${buyInfos }"> 
						<tr>
							<td>${buy.uname }</td><td>${buy.bname }---${buy.count }</td>
							<td>${buy.price }</td><td>${buy.press }</td>
							<td>${buy.author }</td><td>${buy.buytime }</td>
							<td>${buy.subtotal }</td><td>${buy.count }</td>
						</tr>
					</c:forEach>
				</table>				
			</td>
		</tr>
		<!-- 控制页码 -->
		<tr>
			<td>
				<table width="100%" border="0">
					<td>总记录数：${allCount }</td>
					<td>总页数：${pageAllCount }</td>
					<td>当前页码：${currentPageNo }</td>
					<td>
						<a href="<%=basePath%>buyInfoAction_buyInfo.action?page=1&uname=${uname}&beginDate=${beginDate}&endDate=${endDate}">首页 | </a>
						<a href="<%=basePath%>buyInfoAction_buyInfo.action?page=${currentPageNo-1 }&uname=${uname}&beginDate=${beginDate}&endDate=${endDate}">上一页 | </a>
						<a href="<%=basePath%>buyInfoAction_buyInfo.action?page=${currentPageNo+1 }&uname=${uname}&beginDate=${beginDate}&endDate=${endDate}">下一页 | </a>
						<a href="<%=basePath%>buyInfoAction_buyInfo.action?page=${pageAllCount }&uname=${uname}&beginDate=${beginDate}&endDate=${endDate}">尾页  </a>
					</td>
					<td>
					跳转到：<input type="text" name="page" size="3"/>页面<a href="#">go</a>
					</td>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>