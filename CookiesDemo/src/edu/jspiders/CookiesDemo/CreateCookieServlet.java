package edu.jspiders.CookiesDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateCookieServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<h1>Welcome</h1>");
		
		Cookie c1 = new Cookie("cookie1", "100");
		Cookie c2 = new Cookie("cookie2", "200");
		Cookie c3 = new Cookie("cookie3", "300");
		Cookie c4 = new Cookie("cookie4", "400");
		Cookie c5 = new Cookie("cookie5", "500");
		Cookie c6 = new Cookie("cookie6", "600");
		Cookie c7 = new Cookie("cookie7", "700");
		Cookie c8 = new Cookie("cookie8", "800");
		Cookie c9 = new Cookie("cookie9", "900");
		Cookie c10 = new Cookie("cookie10", "1000");
		
		c1.setMaxAge(60*60*24);
		c2.setMaxAge(60*60*24);
		c3.setMaxAge(60*60*24);
		c4.setMaxAge(60*60*24);
		c5.setMaxAge(60*60*24);
		resp.addCookie(c1);
		resp.addCookie(c2);
		resp.addCookie(c3);
		resp.addCookie(c4);
		resp.addCookie(c5);
		resp.addCookie(c6);
		resp.addCookie(c7);
		resp.addCookie(c8);
		resp.addCookie(c9);
		resp.addCookie(c10);
		
		out.print("<h2>Cookies Created</h2>");
	}
}
