package cn.bupt.FS;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class check extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	// private int counter = 0;
	private String name = "bob pw=bobPW";
	private String pw = "bobPW";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://10.108.120.210:3306/FS";
	private static String user = "root";
	private static String password = "112357";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		name = (String) request.getParameter("name");
	//	System.out.println(name);
		pw = (String) request.getParameter("pw");

		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Sorry,can`t find the Driver!");
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement = conn.createStatement();
			String sql = "select * from user where name = '"+name+"' and pw = '"+pw+"'";
			//System.out.println(sql);
			ResultSet rs = statement.executeQuery(sql);
			String name = null;
			if(rs.next()) {
				String ss="";
				ss+=rs.getString("usrid")+","+rs.getString("name")+","+rs.getString("locationx")+","+rs.getString("locationy");
				out.print(ss);
			}
			else
				out.print(-1);
			rs.close();
			conn.close();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}