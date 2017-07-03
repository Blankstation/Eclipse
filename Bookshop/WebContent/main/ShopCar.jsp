<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=basePath%>userAction_checkOut.action" method="post">
		<center>
			<table width="90%">
				<tr><td align="right"><jsp:include page="mhead.jsp"/> </td></tr>
				<tr>
					<td>
						<table width="100%" border="1" cellpadding="0" cellspacing="0">
							<tr>
				      		    <td>书名</td>
				      		    <td>作者</td>
				      		    <td>商品价格</td>
				      		    <td width="5%">数量</td>
				      		    <td>操作</td>
			      		    </tr>
			      		    <c:forEach var="bk" items="${books}">
			       				<tr>
				       				<td>${bk.bkname}</td>
				       				<td>${bk.author}</td>
				       				<td>${bk.price}</td>
				       				<td ><input type="text"  name="${bk.isbn}" value="1" /></td>
				       				<td><a href="#">移除</a></td>
				       			</tr> 				   
			       			</c:forEach> 						
						</table>
					</td>
				</tr>
				<tr>      	
		      	  <td align="center"><input type="submit" value="结算"> &nbsp; 
		      	  <a href="<%=basePath%>userAction_getAllBooks.action">返回</a></td>        	
		        </tr>
			</table>
		</center>	
	</form>
</body>
</html>