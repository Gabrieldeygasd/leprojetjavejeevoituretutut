package vroomvroom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Vérifier les informations d'identification
        boolean isAuthenticated = checkCredentials(username, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            response.sendRedirect("index");
        } else {
            request.setAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
            request.getRequestDispatcher("login").forward(request, response);
        }
    }

    private boolean checkCredentials(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }

}