package org.deliver.transport.jakarta.hello;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/colisDashboard")
public class colisDashboard extends HttpServlet {

    @Inject
    private ColisRessources colisRess;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Colis> allColis = colisRess.findAll();
        if (allColis == null || allColis.isEmpty()) {
            handleNoColisTypes(resp);
            return;
        }


        // on a des colis dans la base de donnée
        PrintWriter out = resp.getWriter();
        out.println("""
           <html>
           <body>
           <h1>Colis Dashboard</h1>
       """);

        for (Colis c : allColis) {
            out.println("""
           <p>%s - <form action="/jakartaee-deliver-transport/modifColis" method="GET">
                <input type="hidden" name="id" value="%d"/>
                <button type="submit">Modifier</button>
            </form>
            <form action="/jakartaee-deliver-transport/getHistoryColis" method="GET">
                <input type="hidden" name="id" value="%d"/>
                <button type="submit">Historique</button>
            </form>
            </p>
       """.formatted(c.toString(), c.getId(), c.getId()));
        }

        out.println("""
           <p><a href="/jakartaee-deliver-transport">Retour au menu principale</a></p>
           </body>
       </html>
       """);
    }

    private void handleNoColisTypes(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("""
       <html>
           <body>
               <h1>No Colis Types Found</h1>
               <p>Please select at least one colis.</p>
           </body>
       </html>
       """);
    }
}
