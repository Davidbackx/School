package ui;

import Exceptions.InputException;
import domain.Game;
import domain.GamesDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.ShortMessage;
import javax.swing.text.View;
import java.io.IOException;
import java.text.CollationKey;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    GamesDB db = new GamesDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination;
        switch (command) {
            case "overview":
                destination = overview(request, response);
                break;
            case "add":
                destination = add(request, response);
                break;
            case "remove":
                destination = remove(request, response);
                break;
            case "searchForm":
                destination = searchForm(request, response);
                break;
            case "search":
                destination = search(request, response);
                break;
            case "prijsYes":
                System.out.println("YES");
                destination = switchShowPrice(request, response, "true");
                break;
            case "prijsNo":
                System.out.println("NO");
                destination = switchShowPrice(request, response, "false");
                break;
            default :
                destination = "index.jsp";
                break;
        }

        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String switchShowPrice(HttpServletRequest request, HttpServletResponse response, String state) {
        Cookie c = new Cookie("showPrice", state);
        response.addCookie(c);

        if (state == null || state.equals("true"))
            request.setAttribute("requestCookie", "true");
        else
            request.setAttribute("requestCookie", "false");

        request.setAttribute("db", db.GetDatabase());
        return "overview.jsp";
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

    private String searchForm(HttpServletRequest request, HttpServletResponse response) {
        return "searchForm.jsp";
    }

    private String search(HttpServletRequest request, HttpServletResponse response) {
        String developer = request.getParameter("developer");
        ArrayList<Game> gm = db.GetGamesOfDev(developer);
        if (gm.size() == 0) gm = null;

        request.setAttribute("dev", developer);
        request.setAttribute("db", gm);
        return "devinfo.jsp";
    }

    private String remove(HttpServletRequest request, HttpServletResponse response) {
        String developer = request.getParameter("developer");
        String naam = request.getParameter("naam");
        db.remove(developer, naam);
        return overview(request, response);
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Game g = new Game();
        setDeveloper(g, request, errors);
        setNaam(g, request, errors);
        setSoort(g, request, errors);
        setPrijs(g, request, errors);

        if (errors.size() == 0) {
            try {
                db.addGame(g);
                return overview(request, response);
            }
            catch (Exception e) {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "form.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookieWithKey(request, "showPrice");

        if (cookie == null || cookie.getValue().equals("true"))
            request.setAttribute("requestCookie", "true");
        else
            request.setAttribute("requestCookie", "false");

        request.setAttribute("db", db.GetDatabase());
        return "overview.jsp";
    }



    private void setDeveloper (Game game, HttpServletRequest request, ArrayList<String> errors) {
        String developer = request.getParameter("developer");
        try {
            game.setDeveloper(developer);
            request.setAttribute("developerPreviousValue", developer);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setNaam (Game game, HttpServletRequest request, ArrayList<String> errors) {
        String naam = request.getParameter("naam");
        try {
            game.setNaam(naam);
            request.setAttribute("naamPreviousValue", naam);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setSoort (Game game, HttpServletRequest request, ArrayList<String> errors) {
        String soort = request.getParameter("soort");
        try {
            game.setSoort(soort);
            request.setAttribute("soortPreviousValue", soort);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setPrijs (Game game, HttpServletRequest request, ArrayList<String> errors) {
        String prijs = request.getParameter("prijs");
        try {
            game.setPrijs(Double.parseDouble(prijs));
            request.setAttribute("prijsPreviousValue", prijs);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }


}