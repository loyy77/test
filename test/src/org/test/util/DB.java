package org.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.jsp.jstl.core.Config;

public class DB {

	// String username = "root";
	// String password = "";
	// String classname = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost:3306/test";

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public static Connection getCon() {
		Properties prop = new Properties();

		InputStream in = Config.class.getResourceAsStream("/jdbc.properties");

		try {
			prop.load(in);

			Class.forName(prop.getProperty("jdbc.driverClassName").trim());
			return DriverManager.getConnection(prop.getProperty("jdbc.url")
					.trim(), prop.getProperty("jdbc.username").trim(), prop
					.getProperty("jdbc.password").trim());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static PreparedStatement getStatement(Connection con, String sql) {
		try {
			return getCon().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getResultSet(String sql) {
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void closeAll(Connection con, PreparedStatement pstmt,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pstmt = null;
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
