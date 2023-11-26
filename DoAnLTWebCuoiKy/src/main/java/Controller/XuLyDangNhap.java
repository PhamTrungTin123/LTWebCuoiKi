package Controller;

import DAO.KhachHangDAO;
import Model.KhachHang;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class XuLyDangNhap
 */
@WebServlet("/XuLyDangNhap")
public class XuLyDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyDangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String pass = request.getParameter("pass");
		String error ="";
		String url = "";
		KhachHang kh = new KhachHangDAO().layThongTinTaiKhoan(username);
		System.out.println(kh);
		if(new KhachHangDAO().kiemTraDangNhap(username, pass)){
			HttpSession session = request.getSession();
			session.setAttribute("user", kh);
			url="/index.jsp";
		}else{
			System.out.println("Loi dang nhap");
			error ="Tên hoặc mật khẩu không đúng";
	        System.out.println("Tên hoặc mật khẩu không đúng");
	        url="/DangNhap.jsp";
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
