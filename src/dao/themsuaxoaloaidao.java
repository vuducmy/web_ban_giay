package dao;

import java.sql.PreparedStatement;

public class themsuaxoaloaidao {
	public int themloai(String maloai ,String tenloai ) {
		try {
			ketnoi kn= new ketnoi();
			kn.KetNoi();
			String sql="insert into Loai(MaLoai,TenLoai) values(?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			cmd.setString(2, tenloai);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int sualoai(String maloai , String tenloai) {
		try {
			ketnoi kn= new ketnoi();
			kn.KetNoi();
			String sql="update Loai set TenLoai = ? where MaLoai = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, tenloai);
			cmd.setString(2, maloai);
			
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	public int xoaloai(String maloai) {
		try {
			ketnoi kn= new ketnoi();
			kn.KetNoi();
			String sql="delete from Loai where MaLoai = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);	
			cmd.setString(1, maloai);		
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
