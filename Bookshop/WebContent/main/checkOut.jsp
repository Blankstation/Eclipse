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
 <form action="<%=basePath%>userAction_payMoney.action?allMoney=${allMoney}" method="post">
	<table align="center" width=90%>
      <tr>
      	<td align=right>      	   
      	  		<jsp:include page="mhead.jsp" />      			
      	</td>
      </tr>
      <tr>
      	<td>
      		<table border="1" width=100%> 
      			<tr>
	      			<td>书名</td>
	      			<td>作者</td>
	      			<td>商品价格</td>
	      			<td width="5%">数量(本)</td>
      			</tr>		       
       			<c:forEach var="bk" items="${books}">        			     				
       			<tr>
	       			<td>${bk.bkname}</td>
	       			<td>${bk.author}</td>
	       			<td>${bk.price}</td>
	       			<td>${bk.buycount}</td>
       			</tr> 					
				</c:forEach>       			
      			<tr><td colspan=4 align=center>账户余额：￥${user.account}  &nbsp;&nbsp;&nbsp;&nbsp; 商品总价：￥${allMoney}</td></tr>
    		</table>
      	</td>
      </tr>
      <tr>
      	
      		<td align="center"><input type="submit" value="付款确认"> &nbsp; <a href="#">返回</a></td>
        	
      </tr>
    
    </table>
	</form>
</body>
</html>