<%@ page pageEncoding="utf-8" %>
<%
String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<style>
  #login_div{ width:400px;
		border:1px solid #6666FF;
		position:relative;
		top:100px;
		padding:10px;
	}
</style>
</head>

<body>
<center>
  <div id="login_div">
    <form id="form1" name="form1" method="post" action="<%=ctx %>/user.do?method=userlogin">
      <table width="348" height="193" border="0">
        <tr>
          <td>用户名：</td>
          <td><label>
            <input name="username" type="text" id="username" size="30" />
          </label></td>
        </tr>
        <tr>
          <td>密码</td>
          <td><label>
            <input name="password" type="password" id="password" size="30" />
          </label></td>
        </tr>
        <tr>
          <td colspan="2" align="left"><label>
            <input type="submit" name="Submit" value=" 登 录 " />
          	<input type="reset"  value="重置"/>
          	<a href="register.jsp">新用户注册</a>
          </label> 
        </tr>
      </table>
    </form>
  </div>
  <br />
</center>
<div>${msg }</div>
</body>
</html>
