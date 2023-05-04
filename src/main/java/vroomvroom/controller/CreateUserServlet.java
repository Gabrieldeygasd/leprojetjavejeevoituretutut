package vroomvroom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vroomvroom.entity.Client;

public class CreateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("createuser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Créer un nouvel objet Client avec les données du formulaire
        Client newClient = new Client(firstName, lastName, email, address);

        List<Client> clients = (List<Client>) getServletContext().getAttribute("clients");
        clients.add(newClient);

        // Rediriger l'utilisateur vers une page de confirmation
        response.sendRedirect("confirmation.jsp");
    }

}