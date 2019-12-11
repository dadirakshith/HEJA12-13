package edu.jspiders.MyFirstDynamicWebApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Java Logic to generate current Date And Time
		
		Date d = new Date();
		String currentDate = d.toString();
		
		String html = "<!doctype HTML>"
				+ "<html>"
				+ "<head>"
				+ "<title>"
				+ "Dynamic resource"
				+ "</title>"
				/*+ "<meta http-equiv=\"refresh\" content=\"1\">"*/
				+ "</head>"
				+ "<body>"
				+ "<h1 style=color:red; background:yellow>"
				+ "This is a Dynamic resource"
				+ "</h1>"
				+ "<h1 style=color:blue; background:skyblue>"
				+ currentDate
				+ "</h1>"
				+ "</body>"
				+ "</html>";
		
		out.println(html);
		
		resp.setHeader("refresh", "2");
	}
}
