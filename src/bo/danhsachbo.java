package bo;

import java.util.ArrayList;

import bean.danhsachbean;
import dao.danhsachdao;

public class danhsachbo {
	  danhsachdao ds= new danhsachdao();
	  public ArrayList<danhsachbean> getdanhsach(){
		  return ds.getdanhsach();
	  }
}
