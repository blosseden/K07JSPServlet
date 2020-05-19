package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class SimpleMVC extends HttpServlet{
	
	/*
	클라이언트의 요청이 get방식이든 post방식이든 하나의 메소드에서
	처리하기 위해 processRequest()메소드로 모든 요청을 전달한다. 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	/*
	 doGet() 혹은 doPost()의 요청을 그대로 전달 받기 위해서는 아래와 같이
	 메소드를 기술해야 한다. request, response객체를 매개변수로 사용하고
	 두가지에 대한 예외를 반드시 처리해야한다. 
	 */
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		Object resultObj = null;
		
		if(type==null) {
			resultObj = "파라미터가 없쪙";
		}
		else if(type.equals("greeting")) {
			
			/*
			 서블릿 클래스에서 application 내장객체를 사용하기 위해
			 getServletContext() 메소드를 이용해서 가져온다. 
			 */
			ServletContext application = this.getServletContext();
			
			//컨텍스트 초기화 파라미터를 가져온다
			String drv = application.getInitParameter("JDBCDriver");
			String url = application.getInitParameter("ConnectionURL");
			
			MemberDAO dao = new MemberDAO(drv, url);
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			boolean isMember = dao.isMember(id, pw);
			
			if(isMember==true) {
				resultObj = "안녕 회원아 ㅎㅅㅎ";
				
			}
			
			else {
				resultObj = "넌 회원이 아니자나";
			}
		}
		else if(type.equals("date")) {
			resultObj = new java.util.Date();
		}
		else {
			resultObj = "헐";
		}
		req.setAttribute("result",resultObj);
		
		RequestDispatcher dis =
				req.getRequestDispatcher("/13Servlet/SimpleMVC.jsp");
		dis.forward(req, resp);
	}
}
