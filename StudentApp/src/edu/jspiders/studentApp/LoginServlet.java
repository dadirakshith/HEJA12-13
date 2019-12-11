package edu.jspiders.studentApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		//validate
		String sid = req.getParameter("id");
		String pswd = req.getParameter("pswd");
		int id = Integer.parseInt(sid);
		
		//Jdbc logic to fetch Data from dataBase
		String fqcn = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/heja12_db?user=root&password=root";
		String query = "select * from student_other_info where id = ? and password=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		PrintWriter out = resp.getWriter();
		try 
		{
			Class.forName(fqcn);
			con = DriverManager.getConnection(dburl);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, pswd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				/*out.println("<h1>Homepage comming soon......</h1>");*/
				RequestDispatcher dispatcher = req.getRequestDispatcher("homepage?regno="+sid);
				dispatcher.forward(req, resp);
			}
			else
			{
				out.println("<h1>Invalid Credentials</h1>");
			}
			
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
