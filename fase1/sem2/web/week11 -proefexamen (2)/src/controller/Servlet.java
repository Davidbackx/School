package controller;

import db.BikeRepository;
import domain.Bike;
import domain.Category;
import domain.DomainException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
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

        Cookie c = getCookieWithName(request,"nieuwsbriefOn");
        setNieuwsbriefAttribuut(request, c == null ? "" : c.getValue());

        String dest;
        switch (command) {
            case "overview":
                dest = overview(request);
                break;
            case "detail":
                dest = detail(request);
                break;
            case "add":
                dest = add(request);
                break;
            case "bikeadd":
                dest = bikeadd(request);
                break;
            case "submitNieuwsbrief":
                dest = submitNieuwsbrief(request, response);
                break;
            case "history":
                dest = history(request);
                break;
            default:
                dest = home(request);
                break;
        }

        request.getRequestDispatcher(dest).forward(request, response);
    }

    private String history(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ArrayList<Bike> history = (ArrayList<Bike>) session.getAttribute("history");
        request.setAttribute("history", history);
        return "bikeOverview.jsp";
    }

    private String submitNieuwsbrief(HttpServletRequest request, HttpServletResponse response) {
        String state = request.getParameter("nieuwsbrief");
        if (state == null) state = "off";

        Cookie c = new Cookie("nieuwsbriefOn", state);
        response.addCookie(c);
        setNieuwsbriefAttribuut (request, state);
        return "index.jsp";
    }

    private void setNieuwsbriefAttribuut (HttpServletRequest request, String state) {
        if (state.equals("on")) {
            request.setAttribute("nieuwsbriefOn", "on");
        }
        else {
            request.setAttribute("nieuwsbriefOn", "off");
        }
    }

    private Cookie getCookieWithName(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name))
                return cookie;
        }
        return null;
    }


    private String add(HttpServletRequest request) {
        ArrayList<String> errors = new ArrayList<>();
        Bike bike = new Bike();
        setItemId(request, errors, bike);
        setBrand(request, errors, bike);
        setCategory(request, errors, bike);
        setDescription(request, errors, bike);
        setPrice(request, errors, bike);

        request.setAttribute("errors", errors);

        if (errors.size() > 0) { return bikeadd(request);
        }
        else {
            db.add(bike);
            return overview(request);
        }
    }

    private String bikeadd(HttpServletRequest request) {
        return "bikeAdd.jsp";
    }

    private String detail(HttpServletRequest request) {
        String id = request.getParameter("itemId");
        if (id != null) {
            Bike bike = db.get(id);
            request.setAttribute("bike", bike);

            HttpSession session = request.getSession();
            ArrayList<Bike> history = (ArrayList<Bike>) session.getAttribute("bikes");
            if (history == null)
                history = new ArrayList<>();
            history.add(bike);
            session.setAttribute("bikes", history);
            return "bikeDetail.jsp";
        }
        else {
            return home(request);
        }
    }

    private String overview(HttpServletRequest request) {
        request.setAttribute("bikes", db.getAll());
        return "bikeOverview.jsp";
    }

    private String home(HttpServletRequest request) {
        return "index.jsp";
    }

    public void setBrand(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String brand = request.getParameter("brand");
        try {
            bike.setBrand(brand);
            request.setAttribute("prevBrand", brand);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setCategory(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String category = request.getParameter("category");
        try {
            Category c = Category.valueOf(category);
            bike.setCategory(c);
            request.setAttribute("prevCategory", category);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
        catch (Exception exc) {
            errors.add("No valid category");
        }
    }

    public void setItemId(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String itemId = request.getParameter("itemId");
        try {
            bike.setItemId(itemId);
            request.setAttribute("prevItemId", itemId);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setDescription(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String description = request.getParameter("description");
        try {
            bike.setDescription(description);
            request.setAttribute("prevDescription", description);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setPrice(HttpServletRequest request, ArrayList<String> errors, Bike bike) {
        String price = request.getParameter("price");
        try {
            double p = Double.parseDouble(price);
            bike.setPrice(p);
            request.setAttribute("prevPrice", price);
        }
        catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
        catch (NumberFormatException exc) {
            errors.add("No valid price");
        }
    }
}
