package controller;

import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bo.themsuaxoagiaybo;

/**
 * Servlet implementation class suagiayadminController
 */
@MultipartConfig
@WebServlet("/suagiayadminController")
public class suagiayadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suagiayadminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magiay = request.getParameter("mg");
		Date ngaynhap = new Date();	
		if (magiay != null) {	
			try {
				String tengiay = request.getParameter("tg");		
				String soluong = request.getParameter("sl");
				String gia = request.getParameter("gia");	
				String maloai = request.getParameter("ml");
				ngaynhap = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaynhap"));  
				Part part = request.getPart("txtfile");
				long g = Long.parseLong(gia);
				long sl = Long.parseLong(soluong);
				String realPath = request.getServletContext().getRealPath("/image_giay");
				String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
				part.write(realPath+"/"+filename);
				String anh = "image_giay" + "/"+ filename ;
				themsuaxoagiaybo tsx = new themsuaxoagiaybo();
				tsx.Suagiay(magiay, tengiay, sl, g, anh	, new java.sql.Date(ngaynhap.getTime()), maloai);				
				RequestDispatcher rd = request.getRequestDispatcher("quanlygiayadminController");
				rd.forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
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
