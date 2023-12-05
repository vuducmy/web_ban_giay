package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.themsuaxoagiaybo;

/**
 * Servlet implementation class suagiayadminController2
 */
@MultipartConfig
@WebServlet("/suagiayadminController2")
public class suagiayadminController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suagiayadminController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String tengiay = "";				
		long soluong = 0;
		long gia = 0;
		String maloai = "";
		String anh = "";
		Date ngaynhap = new Date();
		try {
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "files";
			response.getWriter().println(dirUrl1);
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					String nameimg = fileItem.getName();
					if(nameimg.contains("image_giay/"))
						nameimg = nameimg.split("/")[1];
					if (!nameimg.equals("")) {
						String dirUrl = "E:\\javanangcao\\QLGiay\\WebContent\\image_giay";
						File dir = new File(dirUrl);
						if (!dir.exists()) dir.mkdir();
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);
						try {
							fileItem.write(file);								
							anh = "image_giay/" + nameimg;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				else{
					String item=fileItem.getFieldName();
					if(item.equals("tg"))
						tengiay =fileItem.getString();
					else if(item.equals("sl"))
						soluong = Long.parseLong(fileItem.getString());
					else if(item.equals("gia"))
						gia = Long.parseLong(fileItem.getString());
					else if(item.equals("ml"))
						maloai = fileItem.getString();
					else if(item.equals("ngaynhap"))
						ngaynhap = new SimpleDateFormat("yyyy-MM-dd").parse(fileItem.getString());
				}
			}
			themsuaxoagiaybo tsx = new themsuaxoagiaybo();
			tsx.Suagiay(request.getParameter("mg"), tengiay, soluong, gia, anh	, new java.sql.Date(ngaynhap.getTime()), maloai);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("quanlygiayadminController");
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
