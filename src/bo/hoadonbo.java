package bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();
	public long maxhd() {
		return hddao.maxhd();
	}
	public int Them(long makh) {
		return hddao.Them(makh);
	}
}
