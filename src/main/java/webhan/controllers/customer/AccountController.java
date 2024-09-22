package webhan.controllers.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webhan.models.User;
import webhan.services.impl.UserService;
import webhan.utils.Constant;

import java.io.IOException;

@WebServlet("/account")
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
