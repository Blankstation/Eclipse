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
<title>图书详细页面</title>
</head>
<body>
	<center>
		<table width="90%">
			<tr>
				<td align="right"><jsp:include page="mhead.jsp"/> </td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="1">
						
						<tr>
							<td rowspan="3"><img width="100" height="100" alt="图书封面" src="<%=basePath%>ImgSvl?isbn=${book.isbn}">
							</td>
							<td colspan="2" align="center">${book.bkname }</td>
						</tr>
						<tr>
							<td>商品价格：</td>
							<td>${book.price }</td>
						</tr>
						<tr>
							<td>出版社：</td>
							<td>${book.press }</td>
						</tr>
						<tr>
							<td colspan="3">图书的内容简介 </td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="<%=basePath%>userAction_queryShopCar.action?isbn=${book.isbn}">加入购物车</a>&nbsp;&nbsp;&nbsp;
								<a href="<%=basePath%>userAction_getAllBooks.action">返回</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>