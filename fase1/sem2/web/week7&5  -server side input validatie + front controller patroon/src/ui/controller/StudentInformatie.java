package ui.controller;


import java.io.IOException;
import java.sql.Struct;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			Ik heb niet kunnen vinden hoe ik een foutieve
			label in rood kan inkleuren via css.
	 	*/

    	String destination;
    	String command = request.getParameter("command");
		if (command == null || command.isEmpty()) command = "";

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
				break;
		}
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request, response);
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
		ArrayList<String> errors = new ArrayList<>();

		Student student = new Student();
		setVoornaam(student, request, errors);
		setNaam(student, request, errors);
		setLeeftijd(student, request, errors);
		setStudierichting(student, request, errors);

		if (errors.size() == 0) {
			try {
				klas.voegToe(student);
				return overview(request);
			}
			catch (IllegalArgumentException e) {
				errors.add(e.getMessage());
			}
		}
		request.setAttribute("errors", errors);
		return "studentForm.jsp";
	}

	void setNaam (Student s, HttpServletRequest request, ArrayList<String> errors) {
		String naam = request.getParameter("naam");
		try	{
			s.setNaam(naam);
			request.setAttribute("naamPreviousValue", naam);
		}
		catch (IllegalArgumentException e) {
			request.setAttribute("naamErrorClass", " class=\"rodeKader\"");
			errors.add(e.getMessage());
		}
	}

	void setVoornaam (Student s, HttpServletRequest request, ArrayList<String> errors) {
		String voornaam = request.getParameter("voornaam");
		try	{
			s.setVoornaam(voornaam);
			request.setAttribute("voornaamPreviousValue", voornaam);
		}
		catch (IllegalArgumentException e) {
			errors.add(e.getMessage());
			request.setAttribute("voornaamErrorClass", " class=\"rodeKader\"");
		}
	}

	void setLeeftijd (Student s, HttpServletRequest request, ArrayList<String> errors) {
		String leeftijd = request.getParameter("leeftijd");
		try	{
			s.setLeeftijd(Integer.parseInt(leeftijd));
			request.setAttribute("leeftijdPreviousValue", leeftijd);
		}
		catch (NumberFormatException e) {
			request.setAttribute("leeftijdErrorClass", " class=\"rodeKader\"");
			errors.add("Invalide leeftijd");
		}
		catch (IllegalArgumentException e) {
			errors.add(e.getMessage());
			request.setAttribute("leeftijdErrorClass", " class=\"rodeKader\"");
		}
	}

	void setStudierichting (Student s, HttpServletRequest request, ArrayList<String> errors) {
		String studierichting = request.getParameter("studierichting");
		try	{
			s.setStudierichting(studierichting);
			request.setAttribute("studierichtingPreviousValue", studierichting);
		}
		catch (IllegalArgumentException e) {
			errors.add(e.getMessage());
			request.setAttribute("studierichtingErrorClass", " class=\"rodeKader\"");
		}
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