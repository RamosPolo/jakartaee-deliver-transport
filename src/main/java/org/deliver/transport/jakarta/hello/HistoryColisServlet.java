package org.deliver.transport.jakarta.hello;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/getHistoryColis")
public class HistoryColisServlet extends HttpServlet {

    @Inject
    colisRepository repo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupère l'ID du colis
        String colisIdParam = req.getParameter("id");
        Long colisId = Long.parseLong(colisIdParam);

        // Cherche les historique dans la BDD
        List<ColisHistory> listHistory = repo.findHistorybyId(colisId);

        // penser à les passer en paramètre post pour les afficher

        req.getRequestDispatcher("/WEB-INF/historiqueColis.jsp").forward(req, resp);
    }
}
