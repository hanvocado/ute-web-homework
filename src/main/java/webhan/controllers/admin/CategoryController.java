package webhan.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webhan.services.impl.CategoryService;
import webhan.models.Category;
import webhan.services.ICategoryService;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/insert"})
public class CategoryController extends HttpServlet {
	public ICategoryService categoryService = new CategoryService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("insert")) {
			request.getRequestDispatcher("/views/admin/category.jsp").forward(request, response);			
		} else if (url.contains("categories")) {
			List<Category> li = categoryService.findAll();
			request.setAttribute("cateList", li);
			request.getRequestDispatcher("/views/admin/categories.jsp").forward(request, response);			
		}
	}
}
