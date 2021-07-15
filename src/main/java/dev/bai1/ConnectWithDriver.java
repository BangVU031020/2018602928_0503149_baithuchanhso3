package dev.bai1;
import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.Driver;
import java.util.*;
public class ConnectWithDriver {
	private Connection con = null;
	public ConnectWithDriver() throws Exception {
		String url = "jdbc:mysql://localhost:3306/sp?useSSL=false";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(url, "root", "Taobang1");
	}
	private boolean addLoaiSP(LoaiSP loai) {
		String sql = "INSERT INTO loaisp (TenLoaiSP) "
				+ "VALUES (?)";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, loai.getTenLoaiSP());
			int result = pre.executeUpdate();

			// Kiểm tra kết quả
			if (result == 0) {
				this.con.rollback();
				return false;
			}

			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		try {
			ConnectWithDriver cd = new ConnectWithDriver();
			String sql = "SELECT * FROM sanpham LEFT JOIN loaisp ON sanpham.MaLoaiSP = loaisp.MaLoaiSP";
			PreparedStatement pre = cd.con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			String row = "";
			while (rs.next()) {
				row += "SPID: " + rs.getInt("MaSP");
				row += " Tên SP: " + rs.getString("TenSP");
				row += " Tên Loại SP: " + rs.getString("TenLoaiSP") + "\n";
			}
			System.out.println(row);
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên loại sp: ");
		String ten = sc.next();
		
		LoaiSP l = new LoaiSP(ten);
		
		try {
			ConnectWithDriver cd = new ConnectWithDriver();
			if (!cd.addLoaiSP(l)) {
				System.out.println("Không thành công!");
			} else {
				System.out.println("Thành công!");
			}
			String sql = "SELECT * FROM loaisp l";
			PreparedStatement pre = cd.con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			String row = "";
			while (rs.next()) {
				row += "Mã Loại: " + rs.getInt("MaLoaiSP");
				row += " Tên Loại SP: " + rs.getString("TenLoaiSP") + "\n";
			}
			System.out.println(row);
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
