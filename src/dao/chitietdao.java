package dao;

import java.sql.PreparedStatement;

public class chitietdao {
	public int Them(String magiay, long soluongmua, long mahd) {
		try {
			ketnoi kn= new ketnoi();
			kn.KetNoi();
			String sql="insert into ChiTietHoaDon(MaGiay,SoLuongMua,MaHoaDon,DaMua) values(?,?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, magiay);
			cmd.setLong(2, soluongmua);
			cmd.setLong(3, mahd);
			cmd.setBoolean(4, false);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	   }
}
