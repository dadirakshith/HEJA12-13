package edu.jspiders.attributesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get1")
public class GetAttributesFromRequestServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		ServletContext context = getServletContext();
		Student s1 = (Student) context.getAttribute("student1");
		
		Student s2 = (Student) req.getAttribute("student2");
		
		out.println("<h2>"+s1+"</h2>");
		out.println("<h2>"+s2+"</h2>");
	}
}
