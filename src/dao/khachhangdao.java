package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachangbean;




public class khachhangdao {
	public ArrayList<khachangbean> gettaikhoan() {
		try {
			ArrayList<khachangbean> ds = new ArrayList<khachangbean>();
			ketnoi kn = new ketnoi();
			kn.KetNoi();
			String sql = "select * from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String hoten = rs.getString("HoTen");
				String diachi = rs.getString("DiaChi");
				String sodt = rs.getString("SoDienThoai");			
				String tendn = rs.getString("TenDangNhap");
				String pass = rs.getString("MatKhau");
				ds.add(new khachangbean( hoten, diachi, sodt, tendn, pass));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int dangky(String hoten, String diachi, String sodt, String tendn, String pass)
			throws Exception {
		ketnoi kn = new ketnoi();
		kn.KetNoi();
		String sql = "insert into KhachHang(HoTen, DiaChi, SoDienThoai, TenDangNhap, MatKhau) values(?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, hoten);
		cmd.setString(2, diachi);
		cmd.setString(3, sodt);
		cmd.setString(4, tendn);
		cmd.setString(5, pass);
		return cmd.executeUpdate();
	}

	public long getMakh(String tendn) {
		try {
			ketnoi kn = new ketnoi();
			kn.KetNoi();

			String sql = "select MaKhachHang from KhachHang where TenDangNhap=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				long makh = rs.getLong("MaKhachHang");
				rs.close();
				kn.cn.close();
				return makh;
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	public String getMd5Hash(String pass) {
	    try {
	      MessageDigest md = MessageDigest.getInstance("MD5");
	      byte[] messageDigest = md.digest(pass.getBytes());
	      BigInteger no = new BigInteger(1, messageDigest);
	      String hashtext = no.toString(16);
	      while (hashtext.length() < 32) {
	        hashtext = "0" + hashtext;
	      }
	      return hashtext;
	    } catch (NoSuchAlgorithmException e) {
	      throw new RuntimeException(e);
	    }
	  }
}
