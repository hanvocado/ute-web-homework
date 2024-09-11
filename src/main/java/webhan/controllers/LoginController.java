package webhan.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webhan.models.User;
import webhan.services.impl.UserService;
import webhan.utils.Constant;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
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
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean isRememberMe = false;
		String remember = request.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";

		UserService service = new UserService();
		User user = service.login(email, password);
		if (user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute(Constant.SESSION_USERNAME, user.getId());

			if (isRememberMe) {
				saveRemeberMe(response, user.getId());
			}

			response.sendRedirect(request.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

	private void saveRemeberMe(HttpServletResponse response, String userId) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, userId);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}

}
