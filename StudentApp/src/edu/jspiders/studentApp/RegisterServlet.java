package edu.jspiders.studentApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("sid"));
		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String lname = req.getParameter("lname");
		double marks = Double.parseDouble(req.getParameter("marks"));
		
		String gnm = req.getParameter("gname");
		String rel = req.getParameter("rel");
		String phNo = req.getParameter("phNo");
		
		String email = req.getParameter("mail");
		String password = req.getParameter("pswd");
		
		//JDBC Logic
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/heja12_db?user=root&password=root");
			
			String query1 = "insert into student_info values(?,?,?,?,?)";
			String query2 = "insert into guardian_info values(?,?,?,?)";
			String query3 = "insert into student_other_info values(?,?,?)";
			
			pstmt = con.prepareStatement(query1);
			pstmt.setInt(1, id);
			pstmt.setString(2, fname);
			pstmt.setString(3, mname);
			pstmt.setString(4, lname );
			pstmt.setDouble(5, marks);
			
			int count1 = pstmt.executeUpdate();
			
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setInt(1, id);
			pstmt2.setString(2, gnm);
			pstmt2.setString(3, rel);
			pstmt2.setString(4, phNo);
			
			int count2 = pstmt2.executeUpdate();
			
			pstmt3 = con.prepareStatement(query3);
			pstmt3.setInt(1, id);
			pstmt3.setString(2, email);
			pstmt3.setString(3, password);
			
			int count3 = pstmt3.executeUpdate();
			
			if(count1 > 0 && count2 > 0 && count3 > 0)
			{
				/*out.print("<h1>Inserted Successfully</h1>");*/
				String url = "login.html";
				RequestDispatcher dispatcher = req.getRequestDispatcher(url);
				dispatcher.forward(req, resp);
			}
		}
		catch (ClassNotFoundException e)
		{
			out.print("<h1>NOT Inserted Successfully</h1>");
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			out.print("<h1>NOT Inserted Successfully</h1>");
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt2 != null)
			{
				try
				{
					pstmt2.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt3 != null)
			{
				try
				{
					pstmt3.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
 