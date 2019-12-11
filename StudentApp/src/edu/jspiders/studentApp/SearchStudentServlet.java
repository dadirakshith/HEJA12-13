package edu.jspiders.studentApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		//resp.sendError(1234, "My Msg");
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		PrintWriter out  = resp.getWriter();
		resp.setContentType("text/html");
		
		/*PrintWriter out = resp.getWriter();
		
		StringBuffer s = req.getRequestURL();
		out.println("<h1> URL is "+s);
		System.out.println(s);
		String pro = req.getProtocol();
		out.println("<h1> Protocol is "+pro);
		System.out.println(pro);*/
		
		//jdbc Logic to fetch Data from DataBase
		String fqcn = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/heja12_db?user=root&password=root";
		String query = "select * from student_info where id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String html = "<!doctype HTML>"
				+ "<html>"
				+ "<head>"
				+ "<title>"
				+ "Details"
				+ "</title>"
				+ "</head>"
				+ "<body>";
				
		
		try 
		{
			Class.forName(fqcn);
			con = DriverManager.getConnection(dburl);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				html = html + "<table border=2>"
						+ "<tr>"
						+ "<th>"
						+ "Student Id"
						+ "</th>"
						+ "<th>Student Name</th>"
						+ "<th>Marks</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<td>"
						+ rs.getInt(1)
						+ "</td>"
						+ "<td>"
						+ rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
						+ "</td>"
						+ "<td>"
						+ rs.getDouble(5)
						+ "</td>"
						+ "</tr>"
						+ "</table>"
						+ "</body>"
						+ "</html>";
			}
			else
			{
				html = html 
						+ "<h1>"
						+ "No Students Available for id "+id
						+ "</h1>"
						+ "</body>"
						+ "</html>";
			}
			
			out.println(html);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
