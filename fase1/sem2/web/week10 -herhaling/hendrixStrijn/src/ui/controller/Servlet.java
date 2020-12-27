package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;

        String command = request.getParameter("command");

        if (command == null)
            command = "";

        switch (command) {
            case "yes":
                destination = switchQuote(request, response, "true");
                break;
            case "no":
                destination = switchQuote(request, response, "false");
                break;
            case "home":
                destination = home(request);
                break;
            case "vreemdeling":
                destination = vreemdeling(request, response);
                break;
            case "hallo":
                destination = hallo(request);
                break;
            case "vergeet":
                destination = vergeet(request, response);
                break;
            default:
                destination = home(request);
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String vergeet(HttpServletRequest request, HttpServletResponse response) {
        Cookie c = new Cookie("showVreemdeling", "");
        c.setMaxAge(0);
        response.addCookie(c);
        request.setAttribute("vreemdelingCookie", null);
        return "hallo.jsp";
    }

    private String vreemdeling(HttpServletRequest request, HttpServletResponse response) {
        Cookie c = new Cookie("showVreemdeling", request.getParameter("naam"));
        response.addCookie(c);
        c.setMaxAge(7 * 60 * 60);
        request.setAttribute("vreemdelingCookie", c.getValue());
        return "hallo.jsp";
    }

    private String hallo(HttpServletRequest request) {
        Cookie cookie = getCookieWithKey(request, "showVreemdeling");
        if (cookie != null)
            request.setAttribute("vreemdelingCookie", cookie.getValue());
        else
            request.setAttribute("vreemdelingCookie", null);
        return "hallo.jsp";
    }

    private String home(HttpServletRequest request) {
        Cookie cookie = getCookieWithKey(request, "show");

        if (cookie != null && cookie.getValue().equals("true")){
            request.setAttribute("requestCookie", "true");
        } else {
            request.setAttribute("requestCookie", "false");
        }
        return "index.jsp";
    }


    private String switchQuote(HttpServletRequest request, HttpServletResponse response, String state) {
        Cookie c = new Cookie("show", state);
        response.addCookie(c);


        if (state == null || state.equals("true")) {
            request.setAttribute("requestCookie", "true");
        } else {
            request.setAttribute("requestCookie", "false");
        }

        return "index.jsp";
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }
}
