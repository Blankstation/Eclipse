<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	
	  	
		 function unameValid(){
			 
		     var uname = document.getElementById("uname").value;
		     var url = "<%=basePath%>RegisterSvl?uname=" + uname;
				$.ajax({
					type : "get",
					url : url,
					timeout : 3000,
					dataType : "text",
					success : function(msg) {
						$('#unameAlert').html(msg);
					},
					error : function(msg) {
						alert(msg);
					}
				});

	}

	
	function checkUser(){
		var uname = document.getElementById("uname").value;
		if(uname==null||uname==''){
			alert("用户名不能为空");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<table align="center" width=70%>
		<tr>
			<td align=right><jsp:include page="mhead.jsp" /></td>
		</tr>
		<tr>
			<td>
				<form action="<%=basePath%>userAction_register.action" name="myform" onsubmit="return checkUser()">
					<table border="0" cellpadding="0" cellspacing="0" align="center">
						<tr>
							<td height=100></td>
						</tr>
						<tr>
							<td width="107" height="36">用户名：</td>
							<td width="524"><INPUT name="uname" id="uname" type="text"
								maxlength="16" onblur="unameValid()"> <span
								style="color: #F00;" id="unameAlert"></span></td>
						</tr>
						<tr>
							<td width="107" height="36">密码：</td>
							<td width="524"><INPUT name="pwd" id="pwd" type="password"></td>
						</tr>
						<tr>
							<td width="107" height="36">确认密码：</td>
							<td width="524"><INPUT name="pwd2" type="password"></td>
						</tr>
						<tr>
							<td width="107" height="36">性别：</td>
							<td width="524"><INPUT name="gen" type="radio" value="男"
								checked>男&nbsp; <INPUT name="gen" type="radio" value="女">女
							</td>
						</tr>
						<tr>
							<td width="107" height="36">电子邮件：</td>
							<td width="524"><INPUT name="email" type="text"></td>
						</tr>
						<tr>
							<td colspan=2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="submit" value="提交"> &nbsp; <a
								href="userAction_queryAllBook.action">返回</a>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>