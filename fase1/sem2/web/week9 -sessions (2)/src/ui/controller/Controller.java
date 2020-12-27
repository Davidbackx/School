package ui.controller;

import domain.db.DbException;
import domain.db.ProductDbInMemory;
import domain.model.DomainException;
import domain.model.Product;
import org.seleniumhq.jetty9.server.session.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private ProductDbInMemory productDb = new ProductDbInMemory();

    private final int HOUR_IN_SECONDS = 60 * 60 * 60;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        String command = request.getParameter("command");
        switch (command) {
            case "overview":
                destination = showOverview(request, response);
                break;
            case "addToCart":
                destination = addToCart(request, response);
                break;
            case "showCart":
                destination = showCart(request, response);
                break;
            case "removeFromCart":
                destination = removeFromCart(request, response);
                break;
            default:
                destination = showHome(request, response);
                break;
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(HOUR_IN_SECONDS);

        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    private String removeFromCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList <Product> cart = (ArrayList<Product>) session.getAttribute("cart");
        int deleteId = Integer.parseInt(request.getParameter("productId"));
        if (cart != null) {
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getProductId() == deleteId) {
                    cart.remove(i);
                    break;
                }
            }
        }
        return showCart(request, response);
    }

    private String showCart(HttpServletRequest request, HttpServletResponse response) {
        return "cart.jsp";
    }

    private String addToCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList <Product> cart = (ArrayList<Product>) session.getAttribute("cart");
        if (cart == null)
            cart = new ArrayList<>();

        int id = Integer.parseInt(request.getParameter("productId"));
        cart.add(productDb.get(id));
        session.setAttribute("cart", cart);
        return showOverview(request, response);
    }

    private String showHome(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }


    private String showOverview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", productDb.getAll());
        return "productOverview.jsp";
    }
}
