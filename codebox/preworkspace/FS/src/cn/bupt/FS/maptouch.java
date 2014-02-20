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

public class maptouch extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://10.108.120.210:3306/FS";
	private static String user = "root";
	private static String password = "112357";
	private String picids;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		picids = request.getParameter("picids");
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
			// 要执行的SQL语句
			String ss = "";
			while (!picids.equals("^")) {
				int offset = picids.indexOf(",");
				String picid = picids.substring(0, offset);
				picids = picids.substring(offset + 1);
				String sql = "select * from FP,user where user.usrid=FP.usrid && FP.picid='"
						+ picid + "'";
				ResultSet rs = statement1.executeQuery(sql);
				if(rs.next()){
				String ipic = rs.getString("ipic");
				String ialt = rs.getString("ialt");
				String px = rs.getString("px");
				String py = rs.getString("py");
				String loffset=rs.getString("loffset");
				px=Integer.toString(Integer.valueOf(px).intValue()-Integer.valueOf(loffset).intValue());
				py=Integer.toString(Integer.valueOf(py).intValue()-Integer.valueOf(loffset).intValue()-40);
				ss += " <a class=\"img\" href=\"detail.html?picid="+ picid+ "\" style= \"position:absolute;  left: "+ px+ "px;   top: "+ py+ "px;   z-index:2;height:25px; width :  25px;\">" +
						"<img   src= \"./Pinterest   Home_files/"+ ipic+ "\"  alt=\""+ ialt+ "\" />" +
								"</a>";
				}
				rs.close();
			}
			response.setContentType(CONTENT_TYPE);
			PrintWriter out = response.getWriter();
			out.println(ss);
			out.close();

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