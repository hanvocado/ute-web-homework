package webhan.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webhan.utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/image"})
public class DownloadFileController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("fname");
		File file = new File(Constant.DIR + "/" + fileName);
		
		response.setContentType("image/jpeg");
		
		if(file.exists()) {
			IOUtils.copy(new FileInputStream(file), response.getOutputStream());
		}
	}
}
