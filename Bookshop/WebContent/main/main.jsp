<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();//当前项目名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";//http://localhost:8080/Bookshop
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table width="90%">
			<tr>
				<td align="right"><jsp:include page="mhead.jsp"/></td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<c:forEach items="${books}" var="bk">
						<tr>
							<td rowspan="3"><img width="100" height="100" src="ImgSvl?isbn=${bk.isbn }"/></td>
							<td colspan="2"><a href="<%=basePath%>userAction_bookDetails.action?isbn=${bk.isbn}"> ${bk.bkname }</a></td>
						</tr>
						<tr>
							<td align="center">出版社</td>
							<td>${bk.press }</td>
						</tr>
						<tr>
							<td align="center">价格</td>
							<td>${bk.price }</td>
						</tr>
					</c:forEach>
				</table>
				</td>
			</tr>
		</table>
	</center>

</body>
</html>