package com.example.tptournoi;

import com.example.entities.Joueurs;
import com.example.services.JoueursService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "JoueursServlet", value = "/Joueurs")
public class JoueursServlet extends HttpServlet {

    private JoueursService service;

    public void init() {
        service = new JoueursService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Joueurs> joueurs;
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Joueurs joueur = service.findById(id);
            request.setAttribute("joueurs", joueur);
            request.getRequestDispatcher("WEB-INF/detailsJoueur.jsp").forward(request, response);
        } else {
            request.setAttribute("joueurs", service.findAll());
            request.getRequestDispatcher("WEB-INF/joueurInscription.jsp").forward(request, response);

        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("nomUtilisateur") != null) {
            String nomUtilisateur = request.getParameter("nomUtilisateur");
            String jeuSpecialite = request.getParameter("jeuSpecialite");
            Joueurs joueur = new Joueurs(nomUtilisateur, jeuSpecialite);
            if (service.create(joueur)) {
                response.sendRedirect("Joueurs");

            } else {
                request.setAttribute("error", "Erreur lors de la création du joueur");
                request.getRequestDispatcher("WEB-INF/formulaireAjoutJoueur.jsp").forward(request, response);
            }
        }

    }
}