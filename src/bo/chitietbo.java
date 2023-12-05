package bo;

import dao.chitietdao;

public class chitietbo {
	chitietdao ctdao = new chitietdao();
	public int Them(String masach, long soluongmua, long mahd) {
		return ctdao.Them(masach, soluongmua, mahd);
	}
}
