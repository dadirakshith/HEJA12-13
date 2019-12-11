package edu.jspiders.weurldemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String sFirstNumber = req.getParameter("fnum");
		String sSecondNumber = req.getParameter("snum");
		
		int firstNumber = Integer.parseInt(sFirstNumber);
		int secondNumber = Integer.parseInt(sSecondNumber);
		
		int sum = firstNumber+secondNumber;
		
		
		String html = "<!doctype HTML>"
				+ "<html>"
				+ "<head>"
				+ "<title>"
				+ "web Url Demo"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1 style=color:blue;background:skyblue>"
				+ firstNumber+" + "+secondNumber +" = "+sum
				+ "</h1>"
				+ "</body>"
				+ "</html>";
		
		PrintWriter out = resp.getWriter();
		out.println(html);
	}
}
