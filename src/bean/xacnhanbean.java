package bean;

public class xacnhanbean {
	   private long MaChiTiet;
	    private long MaHoaDon;
	    private String HoTen;
	    private String TenGiay;
	    private long SoLuongMua;
	    private long Gia;
	    private long ThanhTien;
	    private boolean DaMua;
		public xacnhanbean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public xacnhanbean(long maChiTiet, long maHoaDon, String hoTen, String tenGiay, long soLuongMua, long gia,
				long thanhTien, boolean daMua) {
			super();
			MaChiTiet = maChiTiet;
			MaHoaDon = maHoaDon;
			HoTen = hoTen;
			TenGiay = tenGiay;
			SoLuongMua = soLuongMua;
			Gia = gia;
			ThanhTien = thanhTien;
			DaMua = daMua;
		}
		public long getMaChiTiet() {
			return MaChiTiet;
		}
		public void setMaChiTiet(long maChiTiet) {
			MaChiTiet = maChiTiet;
		}
		public long getMaHoaDon() {
			return MaHoaDon;
		}
		public void setMaHoaDon(long maHoaDon) {
			MaHoaDon = maHoaDon;
		}
		public String getHoTen() {
			return HoTen;
		}
		public void setHoTen(String hoTen) {
			HoTen = hoTen;
		}
		public String getTenGiay() {
			return TenGiay;
		}
		public void setTenGiay(String tenGiay) {
			TenGiay = tenGiay;
		}
		public long getSoLuongMua() {
			return SoLuongMua;
		}
		public void setSoLuongMua(long soLuongMua) {
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
		public boolean isDaMua() {
			return DaMua;
		}
		public void setDaMua(boolean daMua) {
			DaMua = daMua;
		}
		
	    
	    
}
