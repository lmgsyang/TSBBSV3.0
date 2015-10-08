<%@ page pageEncoding="UTF-8" %>
<%@ page import="com.ts.bbs.bean.*" %>
<%@ page import="com.ts.bbs.service.impl.*" %>
<%@ page import="java.util.*" %>
<%
String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>回复</title>
<style>
   *{ font-family:"宋体"; font-size:14px;}
   #titleFont{ font-size:20px;}
   table{ border:1px solid #abc4e4;}
   td{ border:1px solid #abc4e4; padding:5px;}
   ul li{  list-style-type: none;
   line-height:25px;
    padding: 0px 10px; 
   }
</style>

</head>

<body>
<%-- 获得request属性 --%>
<%
    
	MessageBean titleMsg = (MessageBean)request.getAttribute("msg");
	List<ReplyBean> replyList = (List<ReplyBean>)request.getAttribute("replylist");
    User titleUser = (User)request.getAttribute("titleUser");
    String userName = titleUser.getUsername();
    String userSex = titleUser.getSex();
    String userCity = titleUser.getCity();
    //获得登录用户
    User loginuser = (User)session.getAttribute("login");
    if(loginuser == null){
       out.print("游客<br>");
     }else{
     	out.print(loginuser.getUsername()+"<br>");
     }
 %>
<table width="810" height="161" border="0" cellpadding="0" cellspacing="0" id="tbBorder">
  <tr bgcolor="#abc4e4">
    <td height="25" colspan="3" align="left"><span id="titleFont"><b>主题：</b></span><span id="titleFont"><b><%=titleMsg.getMsgTopic() %></b></span></td>
  </tr>
  <tr>
    <td width="160"  rowspan="3" align="left" valign="top"><p>作者信息</p>  
	 <ul>
	    <li><%=userName %></li>
	    <li><%=userSex %></li>
	    <li><%=userCity %></li>
    </ul>   
    
    </td>
    <td width="600" height="21" >发表时间：<%=titleMsg.getMsgTime() %></td>
    <td width="66" align="right">#楼主</td>
  </tr>
  <tr>
    <td height="77"  colspan="2" align="left" valign="top"><%=titleMsg.getMsgContent() %></td>
  </tr>
  <tr>
    <td height="18" colspan="2" align="right" valign="top"><a href="#reply">回复</a></td>
  </tr>
</table><br />
<%if(replyList.isEmpty()==false){
	  for(int i=0;i<replyList.size();i++){
	     //获取回复对象
	    ReplyBean reply = replyList.get(i);
	    //根据回复用户ID获得用户对象
	    UserServiceImpl userservice = new UserServiceImpl();
	    User replyUser = userservice.findById(reply.getUserID());
        userName = replyUser.getUsername();
	    userSex = titleUser.getSex();
        userCity = replyUser.getCity();
  %>
 <table width="810" height="154" border="0" cellpadding="0" cellspacing="0" id="tbBorder">
  <tr>
    <td width="160" rowspan="4" align="left" valign="top"><p>作者信息</p>	
     <ul>
	   <li><%=userName %></li>
	   <li><%=userSex %></li>
	    <li><%=userCity %></li>
	 </ul>
	</td>
    <td width="583" height="23">回复时间：<%=reply.getReplyTime() %></td>
    <td width="70" align="right">#<%=i+1 %>楼</td>
  </tr>
  <tr>
    <td height="102" colspan="2" align="left" valign="top"><%=reply.getReplyContent() %></td>
  </tr>
  <tr>
    <td height="21" colspan="2" align="right" valign="top"><a href="#reply">回复</a></td>
  </tr>
</table><br/>
<%}}else{%>
<table width="810" height="30" border="0" cellpadding="0" cellspacing="0" >
     <tr>
      <td align="center" height="30">目前还没有回复信息</td>
     </tr>
   </table><br/>
<%}%>

  <table width="810" height="27" border="0" cellpadding="0" cellspacing="0">
    <tr bgcolor="#abc4e4">
      <td height="27">本论坛回复需要登录&nbsp; |&nbsp;&nbsp;&nbsp; <a href="login.jsp">登录</a>&nbsp;&nbsp; |&nbsp;&nbsp;<a href="register.jsp">新用户注册</a></td>
    </tr>
</table>
  <form id="reply" name="reply" method="post" action="<%=ctx %>/reply.do?method=add" >
    <table width="810" border="0" cellpadding="0" cellspacing="0" id="tbBorder">
     <tr>
        <td><label>
          <input type="hidden" name="msgid" value="<%=titleMsg.getMsgID() %>" />
        </label></td>
      </tr>
      <tr>
        <td><label>
        <textarea name="content" cols="80" rows="10"></textarea>
        </label>       
        </td>
      </tr>
      <tr>
        <td><label>
          <input type="submit" name="submit" value="发表回复" /><a name="reply"></a>
        </label></td>
      </tr>
    </table>
  
  </form>

<%--获取session 判断是否是登录用户--%>

 <%if(null==loginuser){%>
   <script>
      document.reply.content.disabled="disabled";
      document.reply.submit.disabled="disabled";
   </script>
 <%}%>
</body>
</html>
