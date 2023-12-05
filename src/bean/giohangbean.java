package bean;

public class giohangbean {
	private String MaGiay;
	private String TenGiay;
	private String Anh;
	private long Gia;
	private long SoLuong;
	private long ThanhTien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String maGiay, String tenGiay, String anh, long gia, long soLuong) {
		super();
		MaGiay = maGiay;
		TenGiay = tenGiay;
		Anh = anh;
		Gia = gia;
		SoLuong = soLuong;
		this.ThanhTien = soLuong * gia;
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
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
	public long getThanhTien() {
		return SoLuong*Gia;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	
	
}
