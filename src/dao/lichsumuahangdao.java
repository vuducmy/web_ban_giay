package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsumuahangbean;


public class lichsumuahangdao {
	public ArrayList<lichsumuahangbean> getlsmh(long makh){
		try {
			ArrayList<lichsumuahangbean> dslsmh = new ArrayList<lichsumuahangbean>();
			ketnoi cs = new ketnoi();
			cs.KetNoi();
			String sql = "select * from LsMuaHang where MaKhachHang = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, makh);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String tengiay = rs.getString("TenGiay");
				Date NgayMua = rs.getDate("NgayMua");
				int SoLuongMua = rs.getInt("SoLuongMua");
				long Gia = rs.getLong("Gia");
				long ThanhTien = rs.getLong("ThanhTien");	
				boolean DaMua = rs.getBoolean("DaMua");
				dslsmh.add(new lichsumuahangbean(makh, tengiay, SoLuongMua, Gia, ThanhTien,NgayMua, DaMua));
			}
			rs.close();
			cs.cn.close();
			return dslsmh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
