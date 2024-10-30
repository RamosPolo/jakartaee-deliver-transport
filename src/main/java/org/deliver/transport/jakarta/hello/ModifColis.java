package org.deliver.transport.jakarta.hello;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/modifColis")
public class ModifColis extends HttpServlet {

    @Inject
    private colisRepository colisRepo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupère l'ID du colis
        String colisIdParam = req.getParameter("id");
        Long colisId = Long.parseLong(colisIdParam);

        // Cherche le colis dans la BDD
        Colis colis = colisRepo.findById(colisId).orElseThrow(() -> new ServletException("Colis non trouvé..."));

        // envoie le colis au formulaire de modif
        req.setAttribute("colis", colis);

        // formulaire de modif
        req.getRequestDispatcher("/WEB-INF/modifColisForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupère les données du formulaire
        String id = req.getParameter("id");
        String poid = req.getParameter("poid");
        String prix = req.getParameter("prix");
        String origineX = req.getParameter("origineX");
        String origineY = req.getParameter("origineY");
        String destinationX = req.getParameter("destinationX");
        String destinationY = req.getParameter("destinationY");
        String localisationX = req.getParameter("localisationX");
        String localisationY = req.getParameter("localisationY");
        String etat = req.getParameter("etat");

        // Trouve et met à jour le colis
        Colis colis = colisRepo.findById(Long.parseLong(id)).orElseThrow(() -> new ServletException("Colis non trouvé"));
        colis.setPoid(Integer.parseInt(poid));
        colis.setPrix(Float.parseFloat(prix));
        colis.setOrigineX(Long.parseLong(origineX));
        colis.setOrigineY(Long.parseLong(origineY));
        colis.setDestinationX(Long.parseLong(destinationX));
        colis.setDestinationY(Long.parseLong(destinationY));
        colis.setLocalisationX(Long.parseLong(localisationX));
        colis.setLocalisationY(Long.parseLong(localisationY));
        colis.setEtat(etat);

        // Sauvegarde la mise à jour dans la base de données
        colisRepo.update(colis);

        // Redirection vers la liste des colis après la modification
        resp.sendRedirect("/jakartaee-deliver-transport/colisDashboard");
    }
}
