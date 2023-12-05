package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.danhsachbean;

public class danhsachdao {
	 public ArrayList<danhsachbean> getdanhsach(){
	    	try {
	    		ArrayList<danhsachbean> ds= new ArrayList<danhsachbean>();
				ketnoi kn= new ketnoi();
				kn.KetNoi();
				String sql="select * from VXacThucChiTiet where damua = ?";
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				cmd.setBoolean(1, true);
				ResultSet rs=cmd.executeQuery();
				while(rs.next()) {
					  long MaChiTietHD=rs.getLong("MaChiTiet");
					  long MaHoaDon=rs.getLong("MaHoaDon");
					  String hoten=rs.getString("HoTen");
					  String tengiay=rs.getString("TenGiay");
					  long SoLuongMua=rs.getLong("SoLuongMua");
					  long gia=rs.getLong("Gia");
					  long ThanhTien=rs.getLong("ThanhTien");
					  boolean damua=rs.getBoolean("DaMua");
					  ds.add(new danhsachbean(MaChiTietHD, MaHoaDon, hoten, tengiay, SoLuongMua, gia, ThanhTien, damua));
				}
				rs.close();kn.cn.close();
				return ds;
			} catch (Exception e) {
				e.printStackTrace();return null;
			}
	    }
}
