package com.example.tptournoi;

import com.example.entities.Tournoi;
import com.example.services.TournoiService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreationTournoiServlet", value = "/CreationTournoi")
public class CreationTournoiServlet extends HttpServlet {

    private TournoiService service;

    public void init() {
        service = new TournoiService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Tournoi tournoi = service.findById(id);
            request.setAttribute("tournoi", tournoi);
            request.getRequestDispatcher("WEB-INF/detailsTournoi.jsp").forward(request, response);
        } else {
            request.setAttribute("tournoi", service.findAll());
            request.getRequestDispatcher("WEB-INF/creationTournoi.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("nom") != null) {
            String nom = request.getParameter("nom");
            String jeu = request.getParameter("jeu");
            String date = request.getParameter("dateEtHeure");
            String equipe = request.getParameter("equipesList");
            Tournoi tournoi = new Tournoi(nom, jeu, date, equipe);
            if(service.create(tournoi)) {
                response.sendRedirect("CreationTournoi");
            } else {
                request.setAttribute("error", "Erreur lors de la création du tournoi");
                request.getRequestDispatcher("WEB-INF/formulaireAjoutTournoi.jsp").forward(request, response);
            }
        }

    }
}
