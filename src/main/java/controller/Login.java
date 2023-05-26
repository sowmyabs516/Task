package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Student;

@WebServlet("/login")

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Studentdao studentdao = new Studentdao();
		Student student;

		try {
			long mobile = Long.parseLong(email);
			student = studentdao.fetch(mobile);
		} catch (NumberFormatException e) {
			student = studentdao.fetch(email);
		}
		if (student == null) {
			resp.getWriter().print("<h1>Invalid email /Mobile</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			if (student.getPassword().equals(password)) {
				resp.getWriter().print("<h1>Login Success with following details..</h1>");
				req.setAttribute("student", student);
				req.setAttribute("list", studentdao.fetchAll());
				req.getRequestDispatcher("Success.jsp").include(req, resp);

				// resp.setContentType("text/html"); if we want text along with
				// code
				// resp.getWriter()
				// .print("<table border='1'>" + "<tr>" + "<th>Id</th>" +
				// "<th>Name</th>" + "<th>Mobile</th>"
				// + "<th>Email</th>" + "<th>Password</th>" + "</tr>" + "<tr>" +
				// "<th>" + student.getId()
				// + "</th>" + "<th>" + student.getName() + "</th>" + "<th>" +
				// student.getMobile()
				// + "</th>" + "<th>" + student.getEmail() + "</th>" + "<th>" +
				// student.getPassword()
				// + "</th>" + "</tr>" + "</table>");
				// resp.sendRedirect("https://www.google.com");
			} else {
				resp.getWriter().print("<h1>Invalid Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}

		}

	}
}
