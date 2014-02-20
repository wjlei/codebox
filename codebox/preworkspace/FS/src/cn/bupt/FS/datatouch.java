package cn.bupt.FS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class datatouch extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://10.108.120.210:3306/FS";
	private static String user = "root";
	private static String password = "112357";
	private String ismyroom;
	private String name;
	private String usrid;
	private String lx;
	private String ly;
	private int maxid;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ismyroom = request.getParameter("ismyroom");
		name = request.getParameter("name");
		usrid = request.getParameter("usrid");
		lx = request.getParameter("lx");
		ly = request.getParameter("ly");
		String tt = request.getParameter("maxid");
		if (tt != null) {
			maxid = Integer.valueOf(tt).intValue();
			System.out.println(maxid);
		}
		//maxid = 0;
		// 加载驱动程序
		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Sorry,can`t find the Driver!");
				e.printStackTrace();
			}
			// 连续数据库

			Connection conn1 = DriverManager.getConnection(url, user, password);

			if (!conn1.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement1 = conn1.createStatement();
			Statement statement2 = conn1.createStatement();
			Statement statement3 = conn1.createStatement();
			// 要执行的SQL语句
			if (ismyroom.equals("1")) {
				String model = "";
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(("/home/wjlei/workspace/FS/WebContent/myhomemodel.html")),Charset.forName("utf-8")));
				//BufferedReader reader = new BufferedReader(new FileReader(new File("/home/wjlei/workspace/FS/WebContent/myhomemodel.html")));
				String tempString = null;
				while ((tempString = reader.readLine()) != null) {
					model += tempString;
				}
				reader.close();
				String sql = "select * from FP where picid>"
						+ Integer.toString(maxid) + "&&usrid='" + usrid
						+ "' limit 20";
				ResultSet rs = statement1.executeQuery(sql);
				sql = "select * from user where usrid ='" + usrid + "'";
				ResultSet rs2 = statement2.executeQuery(sql);
				rs2.next();
				String ss = "";
				while (rs.next()) {
					String temp = model;
					String usrid = rs2.getString("usrid");
					String name = rs2.getString("name");
					temp = temp.replaceAll("setuser", name);
					temp = temp.replaceAll("setid", usrid);
					String ipic = rs2.getString("ipic");
					String ialt = rs2.getString("ialt");
					temp = temp.replaceAll("setipic", ipic);
					temp = temp.replaceAll("setialt", ialt);
					String picid = rs.getString("picid");
					String alt = rs.getString("alt");
					maxid = Math.max(maxid, Integer.valueOf(picid).intValue());
					String picurl = rs.getString("picurl");
					temp = temp.replaceAll("setpicid", picid);
					temp = temp.replaceAll("setpicalt", alt);
					temp = temp.replaceAll("setpicurl", picurl);
					String title1 = rs.getString("title1");
					String pubtime = rs.getString("pubtime");
					String method = rs.getString("method");
					temp = temp.replaceAll("settitle1", title1);
					temp = temp.replaceAll("setpubtime", pubtime);
					temp = temp.replaceAll("setmethod", method);
					String iclass = rs.getString("class");
					temp = temp.replaceAll("setclass", iclass);
					sql = "SELECT name,comment.usrid,content from FP,comment,user where FP.picid=comment.picid&&user.usrid=comment.usrid && FP.picid='"
							+ picid + "' limit 5";
					ResultSet rs3 = statement3.executeQuery(sql);
					String cc = "";
					while (rs3.next()) {
						String name1 = rs3.getString("name");
						String usrid1 = rs3.getString("usrid");
						String content = rs3.getString("content");
						cc += "<p> <a class=\"link\" href=\"myhome.html?user="
								+ name + "&id=" + usrid1 + "\">" + name1
								+ "</a><span>";
						cc += content + "</span></p>";

					}
					rs3.close();
					temp = temp.replaceAll("setcomment", cc);
					String numlike = rs.getString("numlike");
					temp = temp.replaceAll("setnumlike", numlike);
					String numrepub = rs.getString("numrepub");
					temp = temp.replaceAll("setnumrepub", numrepub);
					ss += temp;

				}
				response.setContentType(CONTENT_TYPE);
				ss = Integer.toString(maxid) + "^" + ss;
				PrintWriter out = response.getWriter();
				out.println(ss);
				out.close();
				rs.close();
				rs2.close();

			} else {
				String model = "";
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(("/home/wjlei/workspace/FS/WebContent/welcomemodel.html")),Charset.forName("utf-8")));
				//BufferedReader reader = new BufferedReader(new FileReader(new File("/home/wjlei/workspace/FS/WebContent/welcomemodel.html")));
				String tempString = null;
				while ((tempString = reader.readLine()) != null) {
					model += tempString;
				}
				reader.close();
				String sql = "select * from FP where picid>"
						+ Integer.toString(maxid) + "&&(FP.px-" + lx
						+ ")*(FP.px-" + lx + ")+(FP.py-" + ly + ")*(FP.py-"
						+ ly + ") < 90000 limit 20";
				ResultSet rs = statement1.executeQuery(sql);
				String ss = "";
				String ll = "";
				while (rs.next()) {
					String usrid = rs.getString("usrid");
					sql = "select * from user where usrid ='" + usrid + "'";
					ResultSet rs2 = statement2.executeQuery(sql);
					rs2.next();
					String name = rs2.getString("name");
					String temp = model;
					temp = temp.replaceAll("setuser", name);
					temp = temp.replaceAll("setid", usrid);
					String ipic = rs2.getString("ipic");
					String ialt = rs2.getString("ialt");
					temp = temp.replaceAll("setipic", ipic);
					temp = temp.replaceAll("setialt", ialt);
					String picid = rs.getString("picid");
					String alt = rs.getString("alt");
					String picurl = rs.getString("picurl");
					maxid = Math.max(maxid, Integer.valueOf(picid).intValue());
					temp = temp.replaceAll("setpicid", picid);
					ll += picid + ",";
					temp = temp.replaceAll("setpicalt", alt);
					temp = temp.replaceAll("setpicurl", picurl);
					String title1 = rs.getString("title1");
					String pubtime = rs.getString("pubtime");
					String method = rs.getString("method");
					temp = temp.replaceAll("settitle1", title1);
					temp = temp.replaceAll("setpubtime", pubtime);
					temp = temp.replaceAll("setmethod", method);
					String iclass = rs.getString("class");
					temp = temp.replaceAll("setclass", iclass);
					// comment
					sql = "SELECT name,comment.usrid,content from FP,comment,user where FP.picid=comment.picid&&user.usrid=comment.usrid && FP.picid='"
							+ picid + "' limit 3";
					ResultSet rs3 = statement3.executeQuery(sql);
					String cc = "";
					while (rs3.next()) {
						String name1 = rs3.getString("name");
						String usrid1 = rs3.getString("usrid");
						String content = rs3.getString("content");
						cc += "<p> <a class=\"link\" href=\"myhome.html?user="
								+ name1 + "&id=" + usrid1 + "\">" + name1
								+ "</a><span>";
						cc += content + "</span></p>";

					}
					rs3.close();
					rs2.close();
					temp = temp.replaceAll("setcomment", cc);
					String numlike = rs.getString("numlike");
					temp = temp.replaceAll("setnumlike", numlike);
					String numrepub = rs.getString("numrepub");
					temp = temp.replaceAll("setnumrepub", numrepub);
					ss += temp;

				}
				ss = ll + "^" + ss;
				ss = Integer.toString(maxid) + "^" + ss;
				response.setContentType(CONTENT_TYPE);
				PrintWriter out = response.getWriter();
				out.println(ss);
				out.close();
				rs.close();

			}
			conn1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}