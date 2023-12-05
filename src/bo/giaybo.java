package bo;

import java.util.ArrayList;

import bean.giaybean;
import dao.giaydao;



public class giaybo {
	giaydao sdao = new giaydao();
	ArrayList<giaybean> ds;
	public ArrayList<giaybean> getGiay(){
		ds =sdao.getGiay();
		return ds;
	}
	public ArrayList<giaybean> TimMa(String maloai){
		ArrayList<giaybean> tam= new ArrayList<giaybean>();
		ArrayList<giaybean> ds= getGiay();
		for(giaybean s: ds)
			if(s.getMaLoai().equals(maloai))
				tam.add(s);
		return tam;
	}
	public ArrayList<giaybean> Tim(String key){
		ArrayList<giaybean> tam= new ArrayList<giaybean>();
		ArrayList<giaybean> ds= getGiay();
		for(giaybean s: ds)
			if(s.getTenGiay().toLowerCase().trim().contains(
			key.toLowerCase().trim())||
			s.getMaLoai().toLowerCase().trim().contains(
					key.toLowerCase().trim())
					)
				tam.add(s);	
		return tam;
	}
	public ArrayList<giaybean> getGiaybyma(String ms){
		ds = sdao.getGiaybyma(ms);
		return ds;
	}
	public ArrayList<giaybean> getGiayPag( int index) {
		ds = sdao.getGiayPagSearch(index, "");
		return ds;
	}

	public ArrayList<giaybean> getGiayPagSearch(int index, String key) {
		ds = sdao.getGiayPagSearch(index, key);
		return ds;
	}

	public int getTotalGiay(String key) {
		return sdao.getTotalGiay(key);
	}
}
