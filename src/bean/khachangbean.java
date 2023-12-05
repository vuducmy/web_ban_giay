package bean;

public class khachangbean {
	
	private String HoTen;
	private String DiaChi;
	private String SoDienThoai;
	private String TenDangNhap;
	private String MatKhau;

	public khachangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachangbean(String hoTen, String diaChi, String soDienThoai, String tenDangNhap, String matKhau) {
		super();
		HoTen = hoTen;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	
	

}
