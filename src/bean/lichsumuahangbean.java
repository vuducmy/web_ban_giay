package bean;

import java.sql.Date;

public class lichsumuahangbean {
	private long MaKhachHang;
	private String TenGiay;
	private int SoLuongMua;
	private long Gia;
	private long ThanhTien;
	private Date NgayMua;	
	private boolean DaMua;
	public lichsumuahangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsumuahangbean(long maKhachHang, String tenGiay, int soLuongMua, long gia, long thanhTien, Date ngayMua,
			boolean daMua) {
		super();
		MaKhachHang = maKhachHang;
		TenGiay = tenGiay;
		SoLuongMua = soLuongMua;
		Gia = gia;
		ThanhTien = thanhTien;
		NgayMua = ngayMua;
		DaMua = daMua;
	}
	public long getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(long maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTenGiay() {
		return TenGiay;
	}
	public void setTenGiay(String tenGiay) {
		TenGiay = tenGiay;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
	

}
