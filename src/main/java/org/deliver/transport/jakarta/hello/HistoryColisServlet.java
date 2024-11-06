package org.deliver.transport.jakarta.hello;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/getHistoryColis")
public class HistoryColisServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    colisRepository repo;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupère l'ID du colis
        String colisIdParam = req.getParameter("id");
        Long colisId = Long.parseLong(colisIdParam);


        // Cherche les historique dans la BDD
        List<ColisHistory> listHistory = repo.findHistorybyId(colisId);
        logger.info("recuperation colis:"+repo.afficheListeHistorique(listHistory));

        List<String> formattedHistories = new ArrayList<>();
        for (ColisHistory history : listHistory) {
            String formattedDate = history.getModifiedAt().format(formatter);
            String row = "<tr>" +
                    "<td>" + history.getColisId() + "</td>" +
                    "<td>" + history.getPoid() + "</td>" +
                    "<td>" + history.getPrix() + "</td>" +
                    "<td>(" + history.getOrigineX() + ", " + history.getOrigineY() + ")</td>" +
                    "<td>(" + history.getDestinationX() + ", " + history.getDestinationY() + ")</td>" +
                    "<td>(" + history.getLocalisationX() + ", " + history.getLocalisationY() + ")</td>" +
                    "<td>" + history.getEtat() + "</td>" +
                    "<td>" + formattedDate + "</td>" +
                    "</tr>";
            formattedHistories.add(row);
        }
        req.setAttribute("formattedHistories", formattedHistories);
        req.getRequestDispatcher("/WEB-INF/historiqueColis.jsp").forward(req, resp);
    }
}
