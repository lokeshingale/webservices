package com.dev.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
private static Connection con;
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lokesh","root","7875");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch(SQLException se) {
		se.printStackTrace();
	}
}
public static Connection getCon() {
	return con;
}
}
