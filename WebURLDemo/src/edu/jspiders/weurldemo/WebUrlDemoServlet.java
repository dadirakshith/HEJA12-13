package edu.jspiders.weurldemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUrlDemoServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String fnm = req.getParameter("fname");
		String lnm = req.getParameter("lname");
		
		PrintWriter out = resp.getWriter();
		
		String html = "<!doctype HTML>"
				+ "<html>"
				+ "<head>"
				+ "<title>"
				+ "web Url Demo"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1 style=color:blue;background:skyblue>"
				+ fnm+" "+lnm
				+ "</h1>"
				+ "</body>"
				+ "</html>";
		
		out.println(html);
		System.out.println(html);
	}
}
