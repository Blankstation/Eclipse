<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">	
	function validName(){
		var name = document.getElementById("bkname").value;
		var NameNull = document.getElementById("NameNull");	
		
		if(name == null || name == ""){
			NameNull.innerHTML = "<font color=\"red\">书名不能为空！</font>";
			return false;
		}else{
			NameNull.innerHTML = "";
			return true;
		}		
	}	
</script>

</head>
<body>
	<table align="center" width="90%">
		<jsp:include page="ahead.jsp"/>
		<tr>
			<td><h2>新书上架</h2></td>
		</tr>
		<tr>
			<td>
				<form action="<%=basePath%>bookAdminAction_addBook.action" method="post" enctype="multipart/form-data" onsubmit="return validName()">
					<table border="1" width="60%" align="center">
						<tr>
							<td>书号ISBN</td>
							<td><input type="text" name="book.isbn"/></td>
						</tr>
						<tr>
							<td>书名</td>
							<td><input type="text" name="book.bkname"/><span id="NameNull"></span></td>
						</tr>
						<tr>
							<td>作者</td>
							<td><input type="text" name="book.author"/></td>
						</tr>
						<tr>
							<td>出版社</td>
							<td><input type="text" name="book.press"/></td>
						</tr>
						<tr>
							<td>出版日期</td>
							<td><input type="text" name="pubdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"/></td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="book.price"/></td>
						</tr>
						<tr>
							<td>图片上传</td>
							<td><input type="file" name="pic"/></td>
						</tr>
						<tr>
							<td colspan=2 align=center><input type=submit value=提交 />${msg}</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>	
	</table>
</body>
</html>