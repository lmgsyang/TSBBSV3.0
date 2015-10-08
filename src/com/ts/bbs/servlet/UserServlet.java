package com.ts.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.bbs.bean.User;
import com.ts.bbs.service.UserService;
import com.ts.bbs.service.impl.UserServiceImpl;
import com.ts.bbs.util.TimeUtil;

public class UserServlet extends HttpServlet {
    //注入service
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
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//获取请求业务方法
			String method = request.getParameter("method");
			if(method.equals("add")){
				addUser(request,response);
			}else if(method.equals("userlogin")){
				userlogin(request,response);
			}
	}

	private void addUser(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		 //获取表单值(根据表单元素的name值)
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		StringBuffer buf = new StringBuffer();//字符串缓冲对象
		String[] shobbys =  request.getParameterValues("hobby");
		for (int i = 0; i < shobbys.length; i++) {
			buf.append(shobbys[i]);
		}
		String hobbys = buf.toString();//转成字符串
		String sbirthday = request.getParameter("birthday");
		Date birthday = Date.valueOf(sbirthday);//转成Date类型
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		//当前时间
		String createtime = TimeUtil.getCurrentTime();
		//组合对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setHobbys(hobbys);
		user.setBirthday(birthday);
		user.setCity(city);
		user.setEmail(email);
		user.setQq(qq);
		user.setCreatetime(createtime);
	
		//调用service
		boolean result = userservice.addUser(user);
		if(result==true){
			//绑定成功消息
			request.setAttribute("msg", "注册成功");
		
		}else{
			request.setAttribute("msg", "注册失败");
		}
		request.getRequestDispatcher("/registerResult.jsp").forward(request, response);
		
	}

	private void userlogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取表单值
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
		UserService userservice = new UserServiceImpl();
		User user = userservice.userlogin(username, password);
		
		if(user==null){
		    request.setAttribute("msg", "<script>alert('用户名或密码错误');</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//获取session
		   HttpSession session = request.getSession();
			//绑定session
			session.setAttribute("login", user);
			response.sendRedirect("index.jsp");
		}
	}

}
