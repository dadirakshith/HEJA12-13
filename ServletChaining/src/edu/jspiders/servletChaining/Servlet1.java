package edu.jspiders.servletChaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1")
public class Servlet1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		/*String url = "http://localhost:8080/ServletChaining/s2";
		String url = "http://localhost:8080/ServletChaining/index.html";*/
		
		

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>This is a response of "+this.getClass().getSimpleName()+"</h1>");
		
		String url = "https://www.github.com";
		
		resp.sendRedirect(url);
	}
}
