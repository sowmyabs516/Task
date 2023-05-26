package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Student;

@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Student student = new Student();
		student.setName(name);
		student.setMobile(mobile);
		student.setEmail(email);
		student.setPassword(password);
		
		Studentdao studentdao=new Studentdao();
		studentdao.update(student);
		resp.getWriter().print("<h1>Updated Successfully</h1>");
		req.getRequestDispatcher("Home.html").include(req, resp);
		}
}
