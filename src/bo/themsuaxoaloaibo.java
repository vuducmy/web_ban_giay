package bo;

import dao.themsuaxoaloaidao;

public class themsuaxoaloaibo {
	themsuaxoaloaidao tsx = new themsuaxoaloaidao();
	public int themloai(String maloai ,String tenloai ) {
		return tsx.themloai(maloai, tenloai);
	}
	
	public int sualoai(String maloai , String tenloai) {
		return tsx.sualoai(maloai, tenloai);
	}
	
	public int xoaloai(String maloai) {
		return tsx.xoaloai(maloai);
	}
}
