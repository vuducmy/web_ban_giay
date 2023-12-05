package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class xacnhanchuyentiendao {
	public void xacnhan(long ma){
    	try {	
			ketnoi kn= new ketnoi();
			kn.KetNoi();
			String sql="update ChiTietHoaDon set damua = ? where MaChiTiet = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setBoolean(1, true);
			cmd.setLong(2, ma);
			ResultSet rs=cmd.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
