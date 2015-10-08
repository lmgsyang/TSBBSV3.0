<%@ page pageEncoding="utf-8" %>
<%
String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
  <head>
    <title>register.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  <style>
   *{font-size:12px;}
   table{background-color:#09f;}
   td{background-color:#fff;}
   div{color:red;}
  </style>
  <script src="js/calendar.js"></script>
  <script type="text/javascript">
  	/*
  	* 显示错误提示信息
  	* eid:错误提示层的ID值
  	* msg:在错误提示层中显示的错误信息
  	*/
  	function showError(eid,msg){
  	   document.getElementById(eid).innerHTML = msg;
  	}
  	
  	function clearError(eid){
  		document.getElementById(eid).innerHTML = "";
  	}
  	/*
  	* 验证用户名
  	* eid：用户名对应的错误层id
  	*/
  	function checkUsername(eid){
      //获取用户名
      var username = document.getElementById("username").value;
      if(username.length == 0){
      	var msg = "用户名不能为空！";
      	showError(eid,msg);
      	return false;
      }
      //要求用户名为字母数字下划线组成6-20位，开头为字母
      var patern = /^[a-zA-Z][a-zA-Z0-9_]{5,19}$/;
      if(patern.test(username)==false){
      	var msg = "用户名为6-20位";
      	showError(eid,msg);
      	return false;
      }
      return true;
  	}
  	/*
  	* 验证密码
  	*
  	*/
  	function checkPassword(eid){
  		var password = document.getElementById("password").value;
  		if(password.length == 0){
        	var msg = "密码不能为空！";
        	showError(eid,msg);
        	return false;
        }
        //要求密码是字母数字6-20位
        var pattern = /^[a-zA-Z0-9]{6,20}$/;
        if(pattern.test(password) == false){
        	var msg = "密码须为6-20位";
        	showError(eid,msg);
        	return false;
        }
        return true;
  	}
  	//验证确认密码
  	function checkConfirmpassword(eid){
  		var password = document.getElementById("password").value;
  		var password2 = document.getElementById("confirmpassword").value;
  		if(password!=password2){
  			var msg = "两次密码不一致";
        	showError(eid,msg);
        	return false;
  		}
  		return true;
  	}
  	//验证邮箱
  	function checkEmail(eid){
  	  var email = document.getElementById("email").value;
  	   //正则表达式
    var pattern = /^[a-zA-Z0-9_-]*@([a-zA-Z0-9_-]+.)+(com|gov|net|com.cn|edu.cn)$/;
	  if(pattern.test(email) == false){
	         msg = "邮箱地址格式不正确";
			showError(eid,msg);
			return(false);	
		}
		return true;
  	}
  	//qq验证
  	function checkqq(eid){
  		var qq = document.getElementById("qq").value;
  		var pattern=/^[1-9]{1}[0-9]{4,10}$/;
  		 if(pattern.test(qq) == false){
	         msg = "QQ格式不正确";
			showError(eid,msg);
			return(false);	
		}
		return true;
  	}
  	
  	
  	function checkForm(){
  		if(checkUsername('username_error')==true&&checkPassword('password_error')==true
  		   &&checkConfirmpasswrod('password2_error')==true&&checkEmail('email_error')==true){
  			return true;
  		}else{
  			alert("请按提示填写");
  			return false;//不提交表单
  		}
  	}
  </script>
  </head>
  
  <body>
  <table width="570" border="0" cellspacing="1" cellpadding="0">
    <tr>
      <td height="26" align="center" style="background-color:#09f">HP-EPM开发X班BBS用户注册</td>
    </tr>
  </table>
  <form name="form1" method="post" action="<%=ctx %>/user.do?method=add" 
  onsubmit="return checkForm();">
    <table width="570" border="0" cellspacing="1" cellpadding="0">
      <tr>
        <td width="132">用户名：</td>
        <td width="228"><label>
          <input type="text" name="username" id="username" onblur="checkUsername('username_error')"
          onfocus="clearError('username_error')">
        </label></td>
        <td width="202"><div id="username_error"></div></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><label>
          <input type="password" name="password" id="password" onblur="checkPassword('password_error')"
          onfocus="clearError('password_error')">
        </label></td>
        <td><div id="password_error"></div></td>
      </tr>
      <tr>
        <td>确认密码：</td>
        <td><label>
          <input type="password" name="confirmpassword" id="confirmpassword" onblur="checkConfirmpassword('password2_error');"
           onfocus="clearError('password2_error')">
        </label></td>
        <td><div id="password2_error"></div></td>
      </tr>
      <tr>
        <td>性别：</td>
        <td><label>
          <input name="sex" type="radio" id="radio" value="男" checked>
          男 
          <input type="radio" name="sex" id="radio2" value="女">
        女</label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>个人爱好：</td>
        <td><label>
          <input name="hobby" type="checkbox" id="hobby" value="文学">
          文学
          <input name="hobby" type="checkbox" id="hobby" value="影视">
          影视
          <input name="hobby" type="checkbox" id="hobby" value="音乐">
          音乐
          <input name="hobby" type="checkbox" id="hobby" value="体育">
          体育
        </label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>出生日期：</td>
        <td><label>
          <input name="birthday" type="text" id="birthday" onclick="calendar();" readonly="true"/>
        </label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>所在城市</td>
        <td><label>
          <select name="city" id="city">
             <option value="济南">济南</option>
             <option value="青岛">青岛</option>
             <option value="威海">威海</option>
             <option value="烟台">烟台</option>
             <option value="临沂">临沂</option>
             <option value="日照">日照</option>
             <option value="淄博">淄博</option>
             <option value="潍坊">潍坊</option>
             <option value="莱芜">莱芜</option>
             <option value="泰安">泰安</option>
             <option value="济宁">济宁</option>
             <option value="菏泽">菏泽</option>
             <option value="东营">东营</option>
             <option value="德州">德州</option>
             <option value="聊城">聊城</option>
             <option value="滨州">滨州</option>
             <option value="枣庄">枣庄</option>
          </select>
        </label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>电子邮件</td>
        <td><label>
          <input type="text" name="email" id="email" onblur="checkEmail('email_error')"
          onfocus="clearError('email_error')">
        </label></td>
        <td><div id="email_error"></div></td>
      </tr>
      <tr>
        <td>QQ:</td>
        <td><label>
          <input type="text" name="qq" id="qq" onblur="checkqq('qq_error')"  onfocus="clearError('qq_error')">
        </label></td>
        <td><div id="qq_error"></div></td>
      </tr>
      <tr>
        <td colspan="3"><label>
          <input type="submit" name="button" id="button" value="提交">
          <input type="reset" name="button2" id="button2" value="重置">
        </label></td>
      </tr>
    </table>
  </form>
</body>
</html>
