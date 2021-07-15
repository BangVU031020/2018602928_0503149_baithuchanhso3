package dev.bai2.nhanvien;

public class NhanVienObject {
	private int MaNV;
	private String HoTen;
	private String NgaySinh;
	private String DiaChi;
	private String SoDT;
	private String GioiTinh;
	public NhanVienObject(int maNV, String hoTen, String ngaySinh, String diaChi, String soDT, String gioiTinh) {
		super();
		MaNV = maNV;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
		SoDT = soDT;
		GioiTinh = gioiTinh;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDT() {
		return SoDT;
	}
	public void setSoDT(String soDT) {
		SoDT = soDT;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	
}
