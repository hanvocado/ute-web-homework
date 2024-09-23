package webhan.controllers.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import webhan.models.User;
import webhan.services.IUserService;
import webhan.services.impl.UserService;
import webhan.utils.Constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/account")
@MultipartConfig
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute(Constant.SESSION_USERNAME);
		if (session != null && userId != null) {
			UserService service = new UserService();
			User user = service.findById(userId);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/views/account.jsp").forward(request, response);
		} else
			response.sendRedirect(request.getContextPath() + "/views/login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute(Constant.SESSION_USERNAME);
		String fullName = request.getParameter("full-name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String oldPassword = request.getParameter("old-password");
		String newPassword = request.getParameter("new-password");
		String passwordCf = request.getParameter("password-cf");
		Part file = request.getPart("img");
		
		IUserService userService = new UserService();
		String alertMsg;
		User user = userService.findById(userId);
		
		if (!email.equals(user.getEmail()) && userService.isEmailExisted(email)) {
			alertMsg = "Email đã tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/views/account.jsp").forward(request, response);
			return;
		}
		
		if (newPassword != null && passwordCf != null && !newPassword.equals(passwordCf)) {
			alertMsg = "Mật khẩu không khớp!";
			request.setAttribute("alert", alertMsg);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/views/account.jsp").forward(request, response);
			return;
		}
	
		String imgName = "";
		if (file != null) {
			imgName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
					
			if (!imgName.equals("")) {
				String realPath = request.getServletContext().getRealPath("/uploads");
				if (!Files.exists(Paths.get(realPath))) {
					Files.createDirectory(Paths.get(realPath));
				}
				file.write(realPath + "/" + imgName);
				user.setImg(imgName);
			}
		}
		
		user.setFullname(fullName);
		user.setEmail(email);
		user.setPassword(newPassword);
		user.setPhone(phone);
		
		user = userService.updateUser(user);
		if (user == null) {
			alertMsg = "Không thành công, vui lòng thử lại!";
		} else {
			alertMsg = "Đã cập nhật!";			
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("/views/account.jsp").forward(request, response);
	}

}
