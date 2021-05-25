package com.spring.maria;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mariadb://127.0.0.1:3306/watching";
		String sql = "SELECT * FROM membership";

                // Ŭ������ ��üȭ, ����̹��� �ε�
		Class.forName("org.mariadb.jdbc.Driver");
                // ���� ���� ����
		Connection con = DriverManager.getConnection(url, "root", "java");
                // ���� ��ü�� ����
		Statement st = con.createStatement();
                // ������ �����Ͽ� ��� ������ ���´�.
		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) { // ���� ���� ������ Bof ~ Eof
			String ex1 = rs.getString("msCode");
			System.out.println(ex1);
		}

		rs.close();
		st.close();
		con.close();
	}

}
