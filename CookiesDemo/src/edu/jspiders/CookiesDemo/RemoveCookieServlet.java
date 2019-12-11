package edu.jspiders.CookiesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class RemoveCookieServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Cookie[] allCookies = req.getCookies();
		
		if(allCookies == null)
		{
			out.println("<h1>Cookies Not Present</h1>");
		}
		else
		{
			for(Cookie c : allCookies)
			{
				if(c.getName().equalsIgnoreCase("cookie2"))
				{
					c.setMaxAge(0);
					resp.addCookie(c);
					out.print("<h1>Cookie Deleted</h1>");
				}
			}
		}
	}
}
