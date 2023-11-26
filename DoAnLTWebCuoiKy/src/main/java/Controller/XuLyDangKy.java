package Controller;

import DAO.KhachHangDAO;
import Model.KhachHang;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XuLyDangKy
 */
@WebServlet("/XuLyDangKy")
public class XuLyDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyDangKy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username= request.getParameter("username");
		String pass= request.getParameter("pass");
		String name= request.getParameter("name");
		String error ="";
		String url = null;
		 KhachHangDAO khachHangDAO = new KhachHangDAO();
		    if (!khachHangDAO.checkUsernameExists(username)) {
		        KhachHang kh = new KhachHang(username, pass, name);

		        if (khachHangDAO.themTaiKhoan(kh)) {
//		            HttpSession session = request.getSession();
//		            session.setAttribute("user", kh);
		            url="/DangNhap.jsp";
		        } else {
		            System.out.println("Lỗi đăng kí");
		        }
		    }
		     else {
		    	 error ="Tài khoản đã tồn tại. Vui lòng chọn tên tài khoản khác.";
		        System.out.println("Tài khoản đã tồn tại. Vui lòng chọn tên tài khoản khác.");
		        url="/DangKy.jsp";
		    }
		    request.setAttribute("error", error);
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
