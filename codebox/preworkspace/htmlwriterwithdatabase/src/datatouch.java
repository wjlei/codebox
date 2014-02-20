import java.sql.*;


public class datatouch {   
public static void main(String[] args){  
String driver = "com.mysql.jdbc.Driver";

// URL指向要访问的数据库名scutcs
//INSERT into user (name , pw)  VALUES ('longlong' , '123'); 
//INSERT into user (name , pw)  VALUES ('duoduo' , '123'); 
//INSERT into user (name , pw)  VALUES ('huahua' , '123'); 
//INSERT into user (name , pw)  VALUES ('jobs' , '123'); 
//INSERT into user (name , pw)  VALUES ('bill' , '123'); 
String url = "jdbc:mysql://10.108.120.210:3306/FS";

// MySQL配置时的用户名

String user = "root";

// Java连接MySQL配置时的密码

String password = "112357";

// 加载驱动程序
try {
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		System.out.println("Sorry,can`t find the Driver!");
		e.printStackTrace();
	}

	// 连续数据库

	Connection conn = DriverManager.getConnection(url, user, password);

	if (!conn.isClosed())

		System.out.println("Succeeded connecting to the Database!");

	// statement用来执行SQL语句

	Statement statement = conn.createStatement();

	// 要执行的SQL语句

	String sql = "select * from user";
	ResultSet rs = statement.executeQuery(sql);
	String name = null;
	while (rs.next()) {
		name = rs.getString("usrid");
		System.out.println(rs.getString("pw") + "\t" + name);
	}
	rs.close();
	conn.close();
} catch (SQLException e) {
	e.printStackTrace();
}
}
}