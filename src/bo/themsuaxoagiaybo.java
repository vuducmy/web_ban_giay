package bo;

import java.util.Date;

import dao.themsuaxoagiaydao;

public class themsuaxoagiaybo {
	themsuaxoagiaydao tsx = new themsuaxoagiaydao();
	public int Themgiay(String magiay, String tengiay, long soluong, long gia,  String anh,Date NgayNhap, String maloai)throws Exception {
		return tsx.Themgiay(magiay, tengiay, soluong, gia, anh, NgayNhap, maloai);
	}
	
	public int Suagiay(String magiay, String tengiay, long soluong, long gia,  String anh,Date NgayNhap, String maloai) throws Exception {
		return tsx.Suagiay(magiay, tengiay, soluong, gia, anh, NgayNhap, maloai);
	}
	
	public int Xoagiay(String magiay) throws Exception {
		return tsx.Xoagiay(magiay);
	}
}
