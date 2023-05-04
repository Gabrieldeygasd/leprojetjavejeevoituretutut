package vroomvroom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkin")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Vérifier si l'utilisateur est connecté
         // Remplacer cette ligne avec votre propre méthode de vérification de connexion
        if (isLoggedIn(request)) {
            // Afficher le lien vers "rdv.jsp"
            response.getWriter().println("<h1>Bienvenue sur la page d'accueil !</h1>");
            response.getWriter().println("<a href=\"rdv.jsp\">RDV</a>");
        } else {
            // Afficher le lien vers "create-account.jsp"
            response.getWriter().println("<h1>Bienvenue sur la page d'accueil !</h1>");
            response.getWriter().println("<a href=\"createuser.jsp\">Créer un compte</a>");
        }
    }


    private boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            // L'utilisateur est connecté
            return true;
        } else {
            // L'utilisateur n'est pas connecté
            return false;
        }
    }

}
