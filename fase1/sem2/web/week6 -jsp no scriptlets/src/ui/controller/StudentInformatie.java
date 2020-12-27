package ui.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.StudentDB;
import domain.model.Student;

@WebServlet("/StudentInfo")
public class StudentInformatie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDB klas =new StudentDB();
       
    public StudentInformatie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

		/*
		String naam=request.getParameter("naam");
		String voornaam=request.getParameter("voornaam");
		String destination="";
		
		if (naam==null || voornaam== null) {
			destination="nietGevonden.jsp";
		}
		else {
			Student student=klas.vind(naam, voornaam);		
			if (student==null) {
				destination="nietGevonden.jsp";
			}		
			else {
				destination="gevonden.jsp";
				request.setAttribute("student", student);			
			}
		}
		RequestDispatcher view=request.getRequestDispatcher(destination);
		view.forward(request, response);		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request, response);
		/*String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String leeftijd = request.getParameter("leeftijd");
		String studierichting = request.getParameter("studierichting");
		
		String destination = "index.html";
		
		if (naam.isEmpty() || voornaam.isEmpty() || leeftijd.isEmpty() || studierichting.isEmpty()) {
			destination = "studentForm.jsp";
		}
		else {
			Student student = new Student(naam, voornaam, Integer.parseInt(leeftijd), studierichting);
			klas.voegToe(student);
			request.setAttribute("studenten", klas.getKlas());
			destination = "studentOverview.jsp";
		}
		
		request.getRequestDispatcher(destination).forward(request, response);*/
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "index.html";
    	String command = request.getParameter("command");
		if (command == null) command = "";

		switch (command) {
			case "voegStudentToe":
				destination = voegStudentToe(request);
				break;
			case "overview":
				destination = overview(request);
				break;
			case "vindStudent":
				destination = vindStudent(request);
				break;
			case "verwijder":
				destination = verwijder(request);
				break;
			case "verwijderBevestig":
				destination = verwijderBevestig(request);
				break;
			default:
				destination = "index.html";
		}
		request.getRequestDispatcher(destination).forward(request, response);
	}

	private String verwijder(HttpServletRequest request) {
    	return "verwijderBevestiging.jsp";
	}

	private String verwijderBevestig(HttpServletRequest request) {
    	if (request.getParameter("submit").equals("Zeker")) {
    		String naam = request.getParameter("naam");
    		String voornaam = request.getParameter("voornaam");
    		klas.verwijder(klas.vind(naam, voornaam));
    		return overview(request);
		}
    	else {
    		return "index.html";
		}
	}

	private String voegStudentToe(HttpServletRequest request) {
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String leeftijd = request.getParameter("leeftijd");
		String studierichting = request.getParameter("studierichting");

		klas.voegToe(new Student(naam, voornaam, Integer.parseInt(leeftijd), studierichting));
		return "StudentInfo?command=overview";
	}

	private String overview(HttpServletRequest request) {
    	request.setAttribute("studenten", klas.getKlas());
    	return "studentOverview.jsp";
	}



	private String vindStudent(HttpServletRequest request) {
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String destination = "";

		if (naam == null || voornaam == null) destination = "nietGevonden.jsp";
		else {
			Student st = klas.vind(naam, voornaam);
			if (st == null) destination = "nietGevonden.jsp";
			else {
				destination = "gevonden.jsp";
				request.setAttribute("student", st);
			}
		}
		return destination;
	}


}