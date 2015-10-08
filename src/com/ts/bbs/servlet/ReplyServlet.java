package com.ts.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.bbs.bean.MessageBean;
import com.ts.bbs.bean.ReplyBean;
import com.ts.bbs.bean.User;
import com.ts.bbs.service.MessageService;
import com.ts.bbs.service.ReplyService;
import com.ts.bbs.service.UserService;
import com.ts.bbs.service.impl.MessageServiceImpl;
import com.ts.bbs.service.impl.ReplyServiceImpl;
import com.ts.bbs.service.impl.UserServiceImpl;
import com.ts.bbs.util.TimeUtil;

public class ReplyServlet extends HttpServlet {
    //注入Service
	MessageService msgservice = new MessageServiceImpl();
	ReplyService replyservice = new ReplyServiceImpl();
	UserService userservice = new UserServiceImpl();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//字符编码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//请求方法
				String method = request.getParameter("method");
				if(method.equals("add")){
					addReply(request,response);
				}if(method.equals("getone")){
					getOneReply(request,response);
				}if(method.equals("update")){
					updateReply(request,response);
				}
	}
   //添加留言
	private void addReply(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		   //获得请求参数(通过隐藏域)，通过session获得登录用户
		   HttpSession session = request.getSession();
		   User user = (User)session.getAttribute("login");
		   int userID = user.getUserid();
		   //(通过隐藏域)，
		   int msgID = Integer.parseInt(request.getParameter("msgid"));
		   String replyContent = request.getParameter("content");
		   String replyTime = TimeUtil.getCurrentTime();
		   String replyIp = request.getRemoteAddr();
		   //组合ReplyBean对象
		   ReplyBean reply = new ReplyBean();
		   reply.setMsgID(msgID);
		   reply.setUserID(userID);
		   reply.setReplyContent(replyContent);
		   reply.setReplyTime(replyTime);
		   reply.setReplyIP(replyIp);
		   //调用service
		   boolean result = replyservice.addReply(reply);
		   String ctx = request.getContextPath();//获得上下文路径
		   if(result==true){
			 //根据编号获得留言对象
		    	 MessageBean msg = msgservice.findById(msgID);
		    	 //获得留言用户
		    	 int userid = msg.getUserID();
		    	 System.out.println(userid);
		    	 User titleUser = userservice.findById(userid);
		    	 //根据编号获得回复集合
		    	 List<ReplyBean> replylist = replyservice.findReplyByMsgid(msgID);
		    	 //绑定属性
		    	 request.setAttribute("msg", msg);
		    	 request.setAttribute("replylist", replylist);
		    	 request.setAttribute("titleUser", titleUser);
		    	 //请求转发,/表示当前上下文路径
		    	 request.getRequestDispatcher("/detail.jsp").forward(request, response);
		   }else{
			   response.sendRedirect(ctx+"/error.jsp");
		   }
		   
		
	}
   //获得某个留言
	private void getOneReply(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		
	}
    //修改留言
	private void updateReply(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
