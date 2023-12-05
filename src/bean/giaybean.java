package bean;

import java.util.Date;

public class giaybean {
	private String MaGiay;
	private String TenGiay;
	private long SoLuong;
	private long Gia;
	private String Anh;
	private Date NgayNhap;
	private String MaLoai;
	public giaybean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giaybean(String maGiay, String tenGiay, long soLuong, long gia, String anh, Date ngayNhap, String maLoai) {
		super();
		MaGiay = maGiay;
		TenGiay = tenGiay;
		SoLuong = soLuong;
		Gia = gia;
		Anh = anh;
		NgayNhap = ngayNhap;
		MaLoai = maLoai;
	}
	public String getMaGiay() {
		return MaGiay;
	}
	public void setMaGiay(String maGiay) {
		MaGiay = maGiay;
	}
	public String getTenGiay() {
		return TenGiay;
	}
	public void setTenGiay(String tenGiay) {
		TenGiay = tenGiay;
	}
	public long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	
	
	
}
