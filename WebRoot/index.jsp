<%@ page pageEncoding="UTF-8" %>
<%@ page import="com.ts.bbs.service.impl.* "%>
<%@ page import="java.util.*" %>
<%@ page import="com.ts.bbs.bean.*" %>
<%
String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>论坛首页</title>
<style>
  .tbBorder{border:1px solid #6699FF;
  }
  .trBack{background-color:#6699FF;}
</style>


</head>

<body>
<%--获取留言信息 --%>
 <% 
    MessageServiceImpl msgservice = new MessageServiceImpl();
    List<MessageInfoBean> infoList = msgservice.findAll();
    //使用隐含对象session 
     User user = (User)session.getAttribute("login");
     if(user == null){
       out.print("游客<br>");
     }else{
     	out.print(user.getUsername()+"<br>");
     }
 %>

<table id="infoTable" name="infoTable" width="810" height="30" border="0" cellpadding="0" cellspacing="0" class="tbBorder">
  <tr class="trBack">
    <td width="352" height="24">主题</td>
    <td width="104">作者</td>
    <td width="66">访问</td>
    <td width="63">回复</td>
    <td width="131">发表日期</td>
  </tr>
  <%if(infoList.isEmpty()) {%>
    <tr>
      <td colspan=5>目前还没有人留言</td>
    </tr>
  <%}else{
    for(int i=0;i<infoList.size();i++){
        MessageInfoBean info = infoList.get(i);
        //将时间分割,只取日期部分
        String times[] = info.getMsgTime().split(" ");
       if(i%2==0){%>   
		  <tr bgcolor="#ffffff">
		    <td width="352"><a href="<%=ctx %>/message.do?method=detail&msgid=<%=info.getMsgID()%>"><%=info.getMsgTopic() %></a></td>
		    <td width="104"><%=info.getUserName() %></td>
		    <td width="66"><%=info.getAccessCount() %></td>
		    <td width="63"><%=info.getReplyCount() %></td>
		    <td width="131"><%=times[0] %></td>
		  </tr>
      <%}else{%>
            <tr bgcolor="#cccccc">
		    <td width="352"><a href="<%=ctx %>/message.do?method=detail&msgid=<%=info.getMsgID()%>"><%=info.getMsgTopic()%></a></td>
		    <td width="104"><%=info.getUserName() %></td>
		    <td width="66"><%=info.getAccessCount() %></td>
		    <td width="63"><%=info.getReplyCount() %></td>
		    <td width="131"><%=times[0] %></td>
		  </tr>
	  <%}
	 }
  }%>
</table><br>
<table width="810" height="29" border="0" class="tbBorder">
  <tr>
    <td height="23" >本论坛发表留言需要登录 |&nbsp;&nbsp; <a href="<%=ctx %>/login.jsp">登录</a>&nbsp;&nbsp; |&nbsp;&nbsp; <a href="<%=ctx %>/register.jsp">新用户注册</a> </td>
  </tr>
</table>

<form id="message" name="message" method="post" action="<%=ctx %>/message.do?method=add ">
  <table width="810" height="81" class="tbBorder">
    <tr>
      <td width="68" align="right" valign="top">标题：</td>
      <td width="666"><label>
        <input name="topic" type="text" id="topic" size="80" />
      </label></td>
    </tr>
    <tr>
      <td align="right" valign="top">内容：</td>
      <td><label>
        <textarea name="content" cols="80" rows="10" id="content"></textarea>
      </label></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <input type="submit" name="submit" value="发表留言"/>
      </label></td>
    </tr>
  </table>
</form>
<%--获取session 判断是否是登录用户--%>

 <%if(null==user){%>
   <script>
      document.message.topic.disabled="disabled";
      document.message.content.disabled="disabled";
      document.message.submit.disabled="disabled";
   </script>
 <%}%>
 
</body>
</html>
