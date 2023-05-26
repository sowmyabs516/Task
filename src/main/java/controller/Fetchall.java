package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Student;
@WebServlet("/fetchall")
public class Fetchall extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
			Student student=new Student();
			Studentdao studentdao=new Studentdao();
			List<Student> list=studentdao.fetchAll();
			req.getRequestDispatcher("Data Fetched from databasse");
			resp.getWriter().print("<table border='1'>" 
					+ "<tr>" 
					+ "<th>Id</th>" 
					+ "<th>Name</th>" 
					+ "<th>Mobile</th>"
					+ "<th>Email</th>"
					+ "<th>Password</th>" 
					+ "</tr>");
			for(Student student1: list){
			resp.getWriter().print("<tr>"
					+ "<th>"+student1.getId()+"</th>"
					+ "<th>"+student1.getName()+"</th>"
					+ "<th>"+student1.getMobile()+"</th>"
					+ "<th>"+student1.getEmail()+"</th>"
					+ "<th>"+student1.getPassword()+"</th>"
					+ "</tr>");}
			resp.getWriter().print("<table>");
			}
	}
