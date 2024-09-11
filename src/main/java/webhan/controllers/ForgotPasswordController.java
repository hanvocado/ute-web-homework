package webhan.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webhan.models.User;
import webhan.services.IUserService;
import webhan.services.impl.UserService;

@SuppressWarnings("serial")
@WebServlet("/forgot-password")
public class ForgotPasswordController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullName = request.getParameter("full-name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordCf = request.getParameter("password-cf");
		IUserService userService = new UserService();
		User user = userService.findByEmail(email);
		String alertMsg = "";
		if (user == null) {
			alertMsg = "Tài khoản không tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
			return;
		}
		
		if (!user.getFullname().toLowerCase().equals(fullName.toLowerCase())) {
			alertMsg = "Thông tin không trùng khớp!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
			return;
		}

		if (!password.equals(passwordCf)) {
			alertMsg = "Mật khẩu không khớp!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
			return;
		}
		boolean isSuccess = userService.updatePassword(user.getId(), password);
		if (isSuccess) {
			request.setAttribute("alert", "Đặt lại mật khẩu thành công! Vui lòng đăng nhập để tiếp tục.");
			RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
			rd.forward(request, response);
			
		} else {
			request.setAttribute("alert", "Lỗi!");
			request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
		}
	}
}
