package controller;

import db.BikeRepository;
import domain.Bike;
import domain.Category;
import domain.DomainException;
import org.w3c.dom.DOMException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.text.CollationKey;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    BikeRepository db = new BikeRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) command = "";

        Cookie c = getCookieWithKey(request,"nieuwsbriefOn");
        setNieuwsbriefCookieAttribuut(request, c == null ? "" : c.getValue());

        String destination;
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "bikeDetails":
                destination = bikeDetails(request, response);
                break;
            case "bikeAdd":
                destination = bikeAdd(request, response);
                break;
            case "newBike":
                destination = newBike(request, response);
                break;
            case "geschiedenis":
                destination = geschiedenis(request, response);
                break;
            case "submitNieuwsbrief":
                destination = submitNieuwbrief(request, response);
                break;
            case "nieuwsbrief":
                destination = nieuwsbrief(request, response);
                break;
            default:
                destination = home(request, response);
                break;
        }

        request.getRequestDispatcher(destination).forward(request, response);
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

    private String submitNieuwbrief(HttpServletRequest request, HttpServletResponse response) {
        String state = request.getParameter("nieuwsbrief");
        if (state == null) state = "off";
        Cookie cookie = new Cookie("nieuwsbriefOn", state);
        response.addCookie(cookie);
        setNieuwsbriefCookieAttribuut(request, state);
        return "index.jsp";
    }

    private void setNieuwsbriefCookieAttribuut (HttpServletRequest request, String state) {
        if (state.equals("on")) {
            request.setAttribute("nieuwsbriefOn", "on");
        }
        else {
            request.setAttribute("nieuwsbriefOn", "off");
        }
    }

    private String nieuwsbrief(HttpServletRequest request, HttpServletResponse response) {
        Cookie c = getCookieWithKey(request,"nieuwsbriefOn");
        setNieuwsbriefCookieAttribuut(request, c.getValue());
        return "nieuwsbrief.jsp";
    }

    private String geschiedenis(HttpServletRequest request, HttpServletResponse response) {
        return "bikeOverview.jsp";
    }

    private void addToGeschiedenis (HttpServletRequest request, Bike bike) {
        HttpSession session = request.getSession();
        ArrayList<Bike> geschiedenis = (ArrayList<Bike>) session.getAttribute("bikes");

        if (geschiedenis == null)
            geschiedenis = new ArrayList<>();

        geschiedenis.add(bike);
        request.getSession().setAttribute("bikes", geschiedenis);
    }

    private String bikeDetails(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("itemId");
        Bike bike = db.get(id);
        request.setAttribute("bike", bike);
        addToGeschiedenis(request, bike);
        return "bikeDetail.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("bikes", db.getAll());
        return "bikeOverview.jsp";
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String newBike(HttpServletRequest request, HttpServletResponse response) {
        Bike bike = new Bike();
        ArrayList<String> errors = new ArrayList<>();

        setItemId(request, errors, bike);
        setBrand(request, errors, bike);
        setCategory(request, errors, bike);
        setDescription(request, errors, bike);
        setPrice(request, errors, bike);

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            return bikeAdd(request, response);
        }
        else {
            db.add(bike);
            return overview(request, response);
        }
    }

    private String bikeAdd(HttpServletRequest request, HttpServletResponse response) {
        return "bikeAdd.jsp";
    }

    private void setItemId(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String item = request.getParameter("itemId");
        try {
            bike.setItemId(item);
            request.setAttribute("itemIdPrev", item);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setBrand(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String item = request.getParameter("brand");
        try {
            bike.setBrand(item);
            request.setAttribute("brandPrev", item);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setCategory(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String item = request.getParameter("category");
        try {
            Category c = Category.valueOf(item);
            bike.setCategory(c);
            request.setAttribute("categoryPrev", item);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
        catch (Exception exc) {
            errors.add("No valid category");
        }
    }

    private void setDescription(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String item = request.getParameter("description");
        try {
            bike.setDescription(item);
            request.setAttribute("descriptionPrev", item);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setPrice(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String item = request.getParameter("price");
        try {
            double p = Double.parseDouble(item);
            bike.setPrice(p);
            request.setAttribute("pricePrev", item);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
        catch (NumberFormatException exc) {
            errors.add("No valid price");
        }
    }
}
