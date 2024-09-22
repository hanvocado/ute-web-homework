package webhan.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import webhan.models.User;
import webhan.services.impl.UserService;
import webhan.utils.Constant;
import webhan.services.*;

@SuppressWarnings("serial")
@WebServlet("/register")
@MultipartConfig
public class RegisterController extends HttpServlet {
	public RegisterController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute(Constant.SESSION_USERNAME) != null) {
//			waiting controller xử lý role
			response.sendRedirect(request.getContextPath() + "/waiting");
			return;
		}

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constant.COOKIE_REMEMBER)) {
					session = request.getSession(true);
					session.setAttribute(Constant.SESSION_USERNAME, cookie.getValue());
					response.sendRedirect(request.getContextPath() + "/waiting");
					return;
				}
			}
		}
		request.getRequestDispatcher("/views/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullName = request.getParameter("full-name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordCf = request.getParameter("password-cf");
		Part file = request.getPart("img");
		String realPath = request.getServletContext().getRealPath("/uploads");
		String imgName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		IUserService userService = new UserService();

		if (!Files.exists(Paths.get(realPath))) {
			Files.createDirectory(Paths.get(realPath));
		}
		file.write(realPath + "/" + imgName);
		
		String alertMsg = "";
		if (userService.isEmailExisted(email)) {
			alertMsg = "Email đã tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
			return;
		}

		if (!password.equals(passwordCf)) {
			alertMsg = "Mật khẩu không khớp!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
			return;
		}
		boolean isSuccess = userService.register(email, password, fullName, imgName);
		if (isSuccess) {
			request.setAttribute("alert", "Tạo tài khoản thành công! Vui lòng đăng nhập để tiếp tục.");
			RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
			rd.forward(request, response);
			
		} else {
			request.setAttribute("alert", "Lỗi!");
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
		}
		
		
	}
}
