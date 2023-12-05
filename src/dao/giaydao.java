package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.giaybean;


public class giaydao {
	public ArrayList<giaybean> getGiay(){
		try {
			ArrayList<giaybean> ds= new ArrayList<giaybean>();
			   //b1: Ket noi vao csdl
			   ketnoi cs = new ketnoi();
			   cs.KetNoi();
			   //b2: Lay du lieu ve
			   String sql = "select * from Giay";
			   PreparedStatement cmd = cs.cn.prepareStatement(sql);
			   ResultSet rs = cmd.executeQuery();
			   //b3: Duyet qua tap du lieu lay ve
			   while(rs.next()) {
				   String magiay = rs.getString("MaGiay");
				   String tengiay = rs.getString("TenGiay");
				   long soluong = rs.getInt("SoLuong");
				   long gia = rs.getInt("Gia");
				   String anh = rs.getString("Anh");
				   Date ngaynhap = rs.getDate("NgayNhap");
				   String maloai = rs.getString("MaLoai");
				   ds.add(new giaybean(magiay, tengiay, soluong,gia, anh, ngaynhap, maloai));
			   }
			   //b4: Dong rs vaf cn
			   rs.close();
			   cs.cn.close();
			   return ds;
		   }catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	   }
	
	public ArrayList<giaybean> getGiaybyma(String mg) {
		ArrayList<giaybean> ds = new ArrayList<giaybean>();
		try {
			ketnoi kn = new ketnoi();
			kn.KetNoi();
			String sql = "SELECT * FROM Giay WHERE MaGiay = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, mg);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
					String magiay = rs.getString("MaGiay");
				   String tengiay = rs.getString("TenGiay");
				   long soluong = rs.getInt("SoLuong");
				   long gia = rs.getInt("Gia");
				   String anh = rs.getString("Anh");
				   Date ngaynhap = rs.getDate("NgayNhap");
				   String maloai = rs.getString("MaLoai");
				   ds.add(new giaybean(magiay, tengiay, soluong,gia, anh, ngaynhap, maloai));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<giaybean> getGiayPagSearch(int index, String key) {
		ArrayList<giaybean> ds = new ArrayList<giaybean>();
		try {
			ketnoi kn = new ketnoi();
			kn.KetNoi();
			String sql = "SELECT * FROM Giay WHERE TenGiay like ? OR MaLoai like ? ORDER BY MaGiay OFFSET ? ROW FETCH NEXT 6 ROWS ONLY";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + key + "%");
			cmd.setString(2, "%" + key + "%");
			cmd.setInt(3, (index - 1) * 6);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String magiay = rs.getString("MaGiay");
				   String tengiay = rs.getString("TenGiay");
				   long soluong = rs.getInt("SoLuong");
				   long gia = rs.getInt("Gia");
				   String anh = rs.getString("Anh");
				   Date ngaynhap = rs.getDate("NgayNhap");
				   String maloai = rs.getString("MaLoai");
				   ds.add(new giaybean(magiay, tengiay, soluong,gia, anh, ngaynhap, maloai));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public int getTotalGiay(String key) {
		try {
			ketnoi kn = new ketnoi();
			kn.KetNoi();
			String sql = "SELECT count(*) FROM Giay WHERE TenGiay like ? OR MaLoai like ? ";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + key + "%");
			cmd.setString(2, "%" + key + "%");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			kn.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
