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

public class friendcheck extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://10.108.120.210:3306/FS";
	private static String user = "root";
	private static String password = "112357";
	private String suser, tuser, req, picid;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		req = request.getParameter("req");
		suser = request.getParameter("suser");
		tuser = request.getParameter("tuser");
		picid = request.getParameter("picid");
		// System.out.println(picids);
		// 加载驱动程序
		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Sorry,can`t find the Driver!");
				e.printStackTrace();
			}

			Connection conn1 = DriverManager.getConnection(url, user, password);

			if (!conn1.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement1 = conn1.createStatement();
			response.setContentType(CONTENT_TYPE);
			PrintWriter out = response.getWriter();
			ResultSet rs = null;
			if (req.equals("check")) {
				String sql = "select * from friendship where userid1='" + suser
						+ "' && userid2='" + tuser + "'";
				rs = statement1.executeQuery(sql);
				if (rs.next()) {
					out.print("1");
				} else {
					out.print("0");
				}

			} else if (req.equals("add")) {
				String sql = "select * from friendship where userid1='" + suser
						+ "' && userid2='" + tuser + "'";
				rs = statement1.executeQuery(sql);
				if (rs.next()) {
					out.print("1");
				} else {
					sql = "insert into friendship (userid1,userid2) values ('"
							+ suser + "' , '" + tuser + "')";
					try {
						// System.out.println(sql);
						statement1.executeUpdate(sql);
						out.print("1");
					} catch (SQLException e) {
						e.printStackTrace();
						out.print("0");
					}
				}
			} else if (req.equals("piccheck")) {
				String sql = "select * from friendship,FP where FP.picid='"
						+ picid + "' && friendship.userid1='" + suser
						+ "' && friendship.userid2=FP.usrid";
				rs = statement1.executeQuery(sql);
				if (rs.next()) {
					out.print("1");
				} else {
					out.print("0");
				}
			} else if (req.equals("picadd")) {
				String sql = "select * from friendship,FP where FP.picid='"
						+ picid + "' && friendship.userid1='" + suser
						+ "' && friendship.userid2=FP.usrid";
				rs = statement1.executeQuery(sql);
				if (rs.next()) {
					out.print("1");
				} else {
					sql = "insert into friendship (userid1,userid2) select "
							+ suser + ",usrid from FP where picid ='" + picid
							+ "'";
					try {
						// System.out.println(sql);
						statement1.executeUpdate(sql);
						out.print("1");
					} catch (SQLException e) {
						e.printStackTrace();
						out.print("0");
					}
				}
			}
			if (rs != null)
				rs.close();
			out.close();
			conn1.close();
			// 要执行的SQL语句

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}