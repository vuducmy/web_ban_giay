package dao;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangdao {
	 public ArrayList<giohangbean> ds= new ArrayList<giohangbean>();
	   
	    public void Them(String magiay, String tengiay,String anh, long soluong, long gia) {
	    for(giohangbean g: ds)
	    	if(g.getMaGiay().equals(magiay)) {
	    		g.setSoLuong(soluong+ g.getSoLuong());
	    		return;
	    	}
	    ds.add(
	    new giohangbean(magiay, tengiay, anh,gia, soluong));
	    }
	    public long TongTien() {
	    	long s=0;
	    	  for(giohangbean g: ds)
	    		  s=s+g.getThanhTien();
	    	  return s;
	    }
	    public void Xoa(String magiay) {
			for (giohangbean g: ds)
				if (g.getMaGiay().trim().equals(magiay.trim())) {
					ds.remove(g);
					return;
				}
		}
	    public void XoaAll() {
	    	ds.removeAll(ds);
		}
		public void Sua(String magiay, long soluong) {
			for (giohangbean g: ds)
				if (g.getMaGiay().trim().equals(magiay.trim())) {
					g.setSoLuong(soluong);
					return;
				}
		}
}
