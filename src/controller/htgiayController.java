package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.giaybean;
import bean.loaibean;
import bo.giaybo;
import bo.loaibo;

/**
 * Servlet implementation class htgiayController
 */
@WebServlet("/htgiayController")
public class htgiayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgiayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ml = request.getParameter("ml");
		String key = request.getParameter("txttk");
		String indexPage = request.getParameter("index");

		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		loaibo lbo = new loaibo();
		ArrayList<loaibean> dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);

		giaybo sbo = new giaybo();
		ArrayList<giaybean> dsgiay;
		int count = 0;
		int endPage = 0;
		if (ml == null || ml == "" && key == null || key == "") {
			count = sbo.getTotalGiay("");
			endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			request.setAttribute("endP", endPage);
			request.setAttribute("index", index);
			
			
			dsgiay = sbo.getGiayPag(index);
			
			request.setAttribute("dsgiay", dsgiay);
		}
		

		if (ml != null && ml != "") {
			count = sbo.getTotalGiay(ml);
			endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			request.setAttribute("endP", endPage);
			request.setAttribute("index", index);
			dsgiay = sbo.getGiayPagSearch(index, ml);
			request.setAttribute("dsgiay", dsgiay);
		} else if (key != null && key != "") {
			count = sbo.getTotalGiay(key);
			endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			request.setAttribute("endP", endPage);
			request.setAttribute("index", index);
			dsgiay = sbo.getGiayPagSearch(index, key);
			request.setAttribute("dsgiay", dsgiay);
		}

		request.setAttribute("ml", ml);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("htgiay.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
