package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import bean.xacnhanbean;

public class xacnhandao {
    public ArrayList<xacnhanbean> getdanhsach(){
    	try {
    		ArrayList<xacnhanbean> ds= new ArrayList<xacnhanbean>();
			ketnoi kn= new ketnoi();
			kn.KetNoi();
			String sql="select * from VXacThucChiTiet where DaMua = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setBoolean(1, false);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				  long MaChiTietHD=rs.getLong("MaChiTiet");
				  long MaHoaDon=rs.getLong("MaHoaDon");;
				  String hoten=rs.getString("HoTen");
				  String tensach=rs.getString("TenGiay");;
				  long SoLuongMua=rs.getLong("SoLuongMua");;
				  long gia=rs.getLong("Gia");;
				  long ThanhTien=rs.getLong("ThanhTien");;
				  boolean damua=rs.getBoolean("DaMua");
				  ds.add(new xacnhanbean(MaChiTietHD, MaHoaDon, hoten, tensach, SoLuongMua, gia, ThanhTien, damua));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();return null;
		}
    }
}
