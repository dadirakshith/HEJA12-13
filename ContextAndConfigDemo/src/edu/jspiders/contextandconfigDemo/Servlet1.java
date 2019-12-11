package edu.jspiders.contextandconfigDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet
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
		out.println("<h2>Movie Name ->"+nm+"</h2>");
		
		ServletConfig config = getServletConfig();
		String l = config.getInitParameter("lang");
		out.println("<h2>Language ->"+l+"</h2>");
	}
}
