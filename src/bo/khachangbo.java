package bo;

import java.util.ArrayList;

import bean.khachangbean;
import dao.khachhangdao;

public class khachangbo {
	khachhangdao khdao = new khachhangdao();
	ArrayList<khachangbean> ds;
	public int dangky(String hoten, String diachi, String sodt, String tendn, String pass) {
		try {
			return khdao.dangky(hoten, diachi, sodt, tendn, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
				
	}
	
	public ArrayList<khachangbean> getkhachhang(){
		ds = khdao.gettaikhoan();
		return ds;
	}
	
	public khachangbean timTaiKhoan(String tendn) {
		ds = khdao.gettaikhoan();
		for(khachangbean item : ds) {
			if(item.getTenDangNhap().equals(tendn))
				return item;
		}
		return null;
	}
	public long getMakh(String tendn) {
		return khdao.getMakh(tendn);
	}
	
	public String getMd5Hash(String pass) {
		return khdao.getMd5Hash(pass);
	}
}
