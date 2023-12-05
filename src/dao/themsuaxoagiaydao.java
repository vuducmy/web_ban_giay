package dao;

import java.sql.PreparedStatement;
import java.util.Date;

public class themsuaxoagiaydao {
	public int Themgiay(String magiay, String tengiay, long soluong, long gia,  String anh,Date NgayNhap, String maloai)throws Exception {
		ketnoi kn = new ketnoi();
		kn.KetNoi();
		String sql = "Insert into Giay(MaGiay, TenGiay, SoLuong, Gia, Anh, NgayNhap, MaLoai) values(?,?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, magiay);
		cmd.setString(2, tengiay);
		cmd.setLong(3, soluong);
		cmd.setLong(4, gia);
		cmd.setString(5, anh);
		cmd.setDate(6, new java.sql.Date(NgayNhap.getTime()));
		cmd.setString(7, maloai);
		return cmd.executeUpdate();

	}
	public int Suagiay(String magiay, String tengiay, long soluong, long gia,  String anh,Date NgayNhap, String maloai) throws Exception {

		ketnoi kn = new ketnoi();
		kn.KetNoi();
		String sql = "Update Giay Set TenGiay = ?, SoLuong = ?, Gia = ?, Anh = ?, NgayNhap = ?, MaLoai = ? Where MaGiay = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tengiay);
		cmd.setLong(2, soluong);
		cmd.setLong(3, gia);
		cmd.setString(4, anh);
		cmd.setDate(5, new java.sql.Date(NgayNhap.getTime()));
		cmd.setString(6, maloai);
		cmd.setString(7, magiay);
		return cmd.executeUpdate();

	}

	public int Xoagiay(String magiay) throws Exception {

		ketnoi kn = new ketnoi();
		kn.KetNoi();
		String sql = "Delete from Giay Where MaGiay = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, magiay);
		return cmd.executeUpdate();

	}
}
