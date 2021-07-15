package dev.bai2;
import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.Driver;

import dev.bai1.LoaiSP;

import java.util.*;
public class ConnectWithDriver {
	private Connection con = null;
	public ConnectWithDriver() throws Exception {
		String url = "jdbc:mysql://localhost:3306/qlbanhang?useSSL=false";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(url, "root", "Taobang1");
	}
	
	public static void main(String[] args) {
		try {
			ConnectWithDriver cd = new ConnectWithDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
