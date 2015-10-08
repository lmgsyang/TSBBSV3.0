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
import com.ts.bbs.service.*;
import com.ts.bbs.service.impl.*;
import com.ts.bbs.util.TimeUtil;

public class MessageServlet extends HttpServlet {
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
			addMessage(request,response);
		}if(method.equals("delete")){
			deleteMessage(request,response);
		}if(method.equals("getone")){
			getOneMessage(request,response);
		}if(method.equals("update")){
			updateMessage(request,response);
		}if(method.equals("detail")){
			getMsgDetail(request,response);
		}
	}
	//查看留言详细信息
    private void getMsgDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	      //获得留言编号
    	 int msgid = Integer.parseInt(request.getParameter("msgid"));
    	 //修改留言访问量
    	 msgservice.updateAccessCount(msgid);
    	 //根据编号获得留言对象
    	 MessageBean msg = msgservice.findById(msgid);
    	 //获得留言用户
    	 int userid = msg.getUserID();
    	 System.out.println(userid);
    	 User titleUser = userservice.findById(userid);
    	 //根据编号获得回复集合
    	 List<ReplyBean> replylist = replyservice.findReplyByMsgid(msgid);
    	 //绑定属性
    	 request.setAttribute("msg", msg);
    	 request.setAttribute("replylist", replylist);
    	 request.setAttribute("titleUser", titleUser);
    	 //请求转发,/表示当前上下文路径
    	 request.getRequestDispatcher("/detail.jsp").forward(request, response);
		
	}

	//添加留言
	private void addMessage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		    //获得留言请求参数
		    String msgTopic = request.getParameter("topic");
		    String msgContent = request.getParameter("content");
		    String msgTime = TimeUtil.getCurrentTime();
		    String ip = request.getRemoteAddr();
		  //得到当前用户
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("login");//session属性名loginUser
	        int userID = user.getUserid();
	        //组合MessageBean对象
	        MessageBean msg = new MessageBean();
	        msg.setUserID(userID);
	        msg.setMsgTopic(msgTopic);
	        msg.setMsgContent(msgContent);
	        msg.setMsgTime(msgTime);
	        msg.setIP(ip);
	        //调用service
	        boolean result = msgservice.addMessage(msg);
	        if(result==true){
	        	//发表成功			
				response.sendRedirect("index.jsp");
	        }else{
	        	response.sendRedirect("error.jsp");
	        }
	        
	}
   //删除留言
	private void deleteMessage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
    //获得某个留言信息
	private void getOneMessage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
   //修改留言
	private void updateMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
	}

}
