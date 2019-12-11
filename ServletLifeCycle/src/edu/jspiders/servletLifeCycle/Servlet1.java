package edu.jspiders.servletLifeCycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet
{
	public Servlet1() 
	{
		System.out.println("In Constructor of Servlet1");
	}
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		System.out.println("In Init method....");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		System.out.println("In service Method.....");
		out.println("<h1>This is the Response of Servlet1</h1>");
	}
	@Override
	public void destroy() 
	{
		System.out.println("In Destroy method.....");
	}
}
