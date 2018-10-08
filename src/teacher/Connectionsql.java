package teacher;

import java.sql.*;

import javax.swing.JOptionPane;
class Conn{
	Connection con;
	public Connection create(String user,String userpass) {
		try {
			/*
			 * 这个forName是要寻找链接数据库驱动
			 * 因此要去网上下载mysql-connector-java-5.1.46并加载到此工程的环境变量中
			 */
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(null, "加载驱动成功!");
		}
		catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "加载驱动失败!");
		}	
		try {
			/*
			 * getConnection(url,数据库登录名，密码)
			 * url:jdbc:mysql://localhost:3306/db1
			 * 其中db1是mysql中数据库的名字，可变，其他都是固定的
			 */
			con =DriverManager.getConnection(
			"jdbc:mysql:"+
			"//localhost:3306/db1",
			user,userpass);
			
			JOptionPane.showMessageDialog(null, "登录成功!");
		}
		catch(SQLException e) {
		
			JOptionPane.showMessageDialog(null, "登录失败!");
		}
		return con;
	}
}