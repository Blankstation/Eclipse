<%@page import="com.bean.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/message.css">
	<title>留言板</title>
</head>
<body>
	<div class="title">
		<header>
			<div class="tmess">
				<h1>留言板</h1>		
			</div>
		</header>
		
		<div class="mess">
			<div class="lmess">
				

	
	<%
		List<Message> messageList = (List<Message>) request.getAttribute("messageList");
	%>
	<table>
		<%
			for (Message message : messageList) {
		%>
		<tr>
			<td>姓名：<%=message.getName()%></td>
			<td>留言：<%=message.getContent()%></td>
		</tr>
		<%
			}
		%>
	</table>
			</div>
			<div class="imess">
				<form action="messageServlet" method="post">
					<textarea name="content" cols="100" rows="3"></textarea><br/>
					<input type="text" placeholder="请输入名字" name="username" />
					<input class="smess" type="submit" name="submit" value="发表"/>
			</form>
		</div>
		</div>
		<footer>
			<div class="copy">
				&copy Messages -2017
			</div>
		</footer>
	</div>
</body>
</html>