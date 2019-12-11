package edu.jspiders.studentApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllStudentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h1>Print all the Students</h1>");
		
		String query = "select * from student_info si, guardian_info gi where si.id = gi.id ";
		String fqcn = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/heja12_db?user=root&password=root";
		Connection con = null;
		Statement stmt = null; 
		ResultSet rs = null;
		
		String html = "<!doctype HTML>"
				+ "<html>"
				+ "<head>"
				+ "<title>All Details</title>"
				+ "</head>"
				+ "<body>"
				+ "<table Border='1' align='center'>"
				+ "<tr>"
				+ "<th>First Name</th>"
				+ "<th>Middle Name</th>"
				+ "<th>Last Name</th>"
				+ "<th>Marks</th>"
				+ "<th>Guardian Name</th>"
				+ "<th>Relation</th>"
				+ "<th>Phone Number</th>"
				+ "</tr>";
				
		try 
		{
			
			Class.forName(fqcn);
			con = DriverManager.getConnection(dburl);
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				/*out.println("<h1>name = "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"</h1>");
				out.println("<h1>marks = "+rs.getDouble(5)+"</h1>");
				out.println("<h1>Gaurdian Name = "+rs.getString(7)+"</h1>");
				out.println("<h1>relation = "+rs.getString(8)+"</h1>");
				out.println("<h1>phone Number = "+rs.getString(9)+"</h1>");
				out.print("-----------------------------------------------");*/
				html = html + "<tr>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getDouble(5)+"</td>"
						+ "<td>"+rs.getString(7)+"</td>"
						+ "<td>"+rs.getString(8)+"</td>"
						+ "<td>"+rs.getString(9)+"</td>"
						+ "</tr>";
			}
			
			html = html + "</table>"
					+ "</html>";
			
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
