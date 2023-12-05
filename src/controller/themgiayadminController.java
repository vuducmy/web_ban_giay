package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bo.loaibo;
import bo.themsuaxoagiaybo;

/**
 * Servlet implementation class themgiayadminController
 */
@MultipartConfig
@WebServlet("/themgiayadminController")
public class themgiayadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themgiayadminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String magiay = request.getParameter("mg");
		String tengiay = request.getParameter("tg");		
		String soluong = request.getParameter("sl");
		String gia = request.getParameter("gia");	
		String maloai = request.getParameter("ml");
		
		if (magiay != null) {	
			try {
				Part part = request.getPart("txtfile");
				long g = Long.parseLong(gia);
				long sl = Long.parseLong(soluong);
				String realPath = request.getServletContext().getRealPath("/image_giay");
				String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
				part.write(realPath+"/" +File.separator+filename);
				String anh = "image_giay" + "/"+ filename ;
				themsuaxoagiaybo tsx = new themsuaxoagiaybo();
				tsx.Themgiay(magiay, tengiay, sl, g, anh, new java.sql.Date(new Date().getTime()), maloai);				
				RequestDispatcher rd = request.getRequestDispatcher("quanlygiayadminController");
				rd.forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			loaibo lbo = new loaibo();
			request.setAttribute("dsloai", lbo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("themgiayadmin.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
