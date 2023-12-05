package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	 public ArrayList<loaibean> getloai(){
		   try {
			   ArrayList<loaibean> dsloai= new ArrayList<loaibean>();
			   //b1: Ket noi vao csdl
			   ketnoi cs = new ketnoi();
			   cs.KetNoi();
			   //b2: Lay du lieu ve
			   String sql = "select * from Loai";
			   PreparedStatement cmd = cs.cn.prepareStatement(sql);
			   ResultSet rs = cmd.executeQuery();
			   //b3: Duyet qua tap du lieu lay ve
			   while(rs.next()) {
				   String maloai = rs.getString("MaLoai");
				   String tenloai = rs.getString("TenLoai");
				   dsloai.add(new loaibean(maloai, tenloai));
			   }
			   //b4: Dong rs vaf cn
			   rs.close();
			   cs.cn.close();
			   return dsloai;
		   }catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	 }
}
