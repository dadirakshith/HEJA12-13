package edu.jspiders.attributesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetAttributesServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>Attributes Demo</h1>");
		
		Student s = new Student(10, "Pavan", 89.63);
		
		ServletContext context = getServletContext();
		context.setAttribute("student1", s);
		
		
		req.setAttribute("student2", new Student(20, "Rambabu", 78.63));
		
		out.println("<h2>Atributes are Setted</h2>");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("get1");
		dispatcher.forward(req, resp);
		
		
	}
}
