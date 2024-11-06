package org.deliver.transport.jakarta.hello;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/storeColis")
public class storeColisServlet extends HttpServlet {

    @Inject
    private colisRepository colisRepo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/registerColis.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] poidColis = req.getParameterValues("poid");
        String[] valueColis = req.getParameterValues("prix");
        String[] origine_1Colis = req.getParameterValues("origine_1");
        String[] origine_2Colis = req.getParameterValues("origine_2");
        String[] destination_1Colis = req.getParameterValues("destination_1");
        String[] destination_2Colis = req.getParameterValues("destination_2");
        String[] localisation_1Colis = req.getParameterValues("localisation_1");
        String[] localisation_2Colis = req.getParameterValues("localisation_2");
        String[] etatColis = req.getParameterValues("etat");

        Colis colis = new Colis();
        try {
            colis.setPoid(Integer.parseInt(poidColis[0]));
            colis.setPrix(Float.parseFloat(valueColis[0]));
            colis.setOrigineX(Long.parseLong(origine_1Colis[0]));
            colis.setOrigineY(Long.parseLong(origine_2Colis[0]));
            colis.setDestinationX(Long.parseLong(destination_1Colis[0]));
            colis.setDestinationY(Long.parseLong(destination_2Colis[0]));
            colis.setLocalisationX(Long.parseLong(localisation_1Colis[0]));
            colis.setLocalisationY(Long.parseLong(localisation_2Colis[0]));
            colis.setEtat(etatColis[0]);
        } catch (NumberFormatException e) {
            throw new ServletException("Erreur lors de la conversion des données du formulaire", e);
        }

        try {
            colisRepo.create(colis);
            colisRepo.insertHistory(colis);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de la création du colis en base de données", e);
        }

        resp.sendRedirect("/jakartaee-deliver-transport/colisDashboard");
    }
}
