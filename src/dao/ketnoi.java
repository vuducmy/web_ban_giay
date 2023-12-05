package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ketnoi {
	public Connection cn;
	public void KetNoi() throws Exception{
		//b1: Xac dinh ht QTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("OK buoc 1");
		String url = "jdbc:sqlserver://LAPTOP-MT4J20EM\\SQLEXPRESS:1433;databaseName=QLGiay;user=sa; password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("OK buoc 2");
	}
	public static void main(String[] ts) {
		try {
			ketnoi cs = new ketnoi();
			cs.KetNoi();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
