package com.udacity.jspandservlets;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	public FirstServlet() {
		super();
		System.out.println("**************** Inside the no arg constructor ****************************");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//called before sending any request to the server
		// as soon as the object is created
		super.init(config);
		System.out.println("**************** Inside the init method ****************************");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//no need to override
		super.service(req, resp);
		System.out.println("**************** Inside the service method ****************************");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("**************** Inside the destroy method ****************************");
	}
	
	//doGet
/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String fullName = firstName.concat(lastName);
		System.out.println("Your name is "+fullName);
	}
*/	
	//doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> students = new ArrayList<>();
		
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String fullName = firstName.concat(lastName);
		
		Student student = new Student();
		student.setName("Bharat Singur");
		student.setAge(25);
		student.setCountry("India");
		students.add(student);
		
		student = new Student();
		student.setName("Bhusan Singur");
		student.setAge(26);
		student.setCountry("India");
		students.add(student);
		
		student = new Student();
		student.setName("Jack Willow");
		student.setAge(21);
		student.setCountry("USA");
		students.add(student);
		
		student = new Student();
		student.setName("Monica");
		student.setAge(25);
		student.setCountry("USA");
		students.add(student);
		
		req.setAttribute("students", students);
		
		/*
		 	PrintWriter writer = resp.getWriter();
			writer.println("<!doctype html><html><body><h1>Your name is "+fullName+"</h1></body></html>");
		*/
		
		//resp.sendRedirect("./templates/test.html");
		req.setAttribute("name", fullName);
		req.setAttribute("student", student);
		
		/*
			String [] countries = {"Nepal", "India", "Australia", "Japan", "China", "America"};
			req.setAttribute("countries", countries);
		*/
		RequestDispatcher dispatcher= req.getRequestDispatcher("./templates/output.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
