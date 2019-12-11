package edu.jspiders.contextandconfigDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet4 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>This is the Response of "+this.getClass().getSimpleName()+"</h1>");
		
		ServletContext context = getServletContext();
		String nm = context.getInitParameter("movieName");
		out.println("<h2>"+nm+"</h2>");
	}
}
